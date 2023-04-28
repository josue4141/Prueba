/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dao.DaoCreditoFiscal;
import com.dao.DaoFaturaConsumidorFinal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.modelo.creditoFiscal;
import com.modelo.faturaConsumidorFinal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

/**
 *
 * @author josue
 */
@WebServlet(name = "FacturaController", urlPatterns = {"/facturaController"})
@MultipartConfig
public class FacturaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        RequestDispatcher rd = null;
        DaoCreditoFiscal daoCreditoFiscal = new DaoCreditoFiscal();
        DaoFaturaConsumidorFinal daoFaturaConsumidorFinal = new DaoFaturaConsumidorFinal();

        if (request.getParameter("btnCargar") != null) {
            final Part archivoPart = request.getPart("archivo");
            // Crear un objeto File con el nombre del archivo
            String nombreArchivo = Paths.get(archivoPart.getSubmittedFileName()).getFileName().toString(); // obtener solo el nombre del archivo sin la ruta completa
            File archivo = new File(nombreArchivo);
            InputStream inp = new FileInputStream(archivo);
            Workbook wb = WorkbookFactory.create(inp);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Sheet sheet = wb.getSheetAt(0);
            int numeroFilas = sheet.getLastRowNum();
            for (int i = 3; i <= numeroFilas; i++) {
                Row fila = sheet.getRow(i);
                if (fila == null) {
                    continue;
                }
                try {
                    // Crear objeto con los datos de la fila
                    creditoFiscal fiscal = new creditoFiscal();
                    fiscal.setNit(fila.getCell(0).getStringCellValue());
                    fiscal.setNrc(fila.getCell(1).getStringCellValue());
                    fiscal.setIdDepartamentoEmisor(Double.valueOf(fila.getCell(2).getNumericCellValue()).intValue());
                    fiscal.setIdMunicipioEmisor(Double.valueOf(fila.getCell(3).getNumericCellValue()).intValue());
                    fiscal.setDireccionEmisor(fila.getCell(4).getStringCellValue());
                    Date date = fila.getCell(5).getDateCellValue();
                    fiscal.setFechaEnvio(dateFormat.format(date));
                    date = fila.getCell(6).getDateCellValue();
                    fiscal.setFechaEmision(dateFormat.format(date));
                    fiscal.setTerminal(fila.getCell(7).getStringCellValue());
                    fiscal.setNumFactura(Double.valueOf(fila.getCell(8).getNumericCellValue()).intValue());
                    fiscal.setCorrelativoInterno(Double.valueOf(fila.getCell(9).getNumericCellValue()).intValue());
                    fiscal.setNumeroTransaccion(Double.valueOf(fila.getCell(10).getNumericCellValue()).intValue());
                    fiscal.setCodigoUsuario(Double.valueOf(fila.getCell(11).getNumericCellValue()).intValue());
                    fiscal.setNombreUsuario(fila.getCell(12).getStringCellValue());
                    fiscal.setCorreoUsuario(fila.getCell(13).getStringCellValue());
                    fiscal.setCajaSuc(fila.getCell(14).getStringCellValue());
                    fiscal.setTipoDocumento(fila.getCell(15).getStringCellValue());
                    fiscal.setPdv(fila.getCell(16).getStringCellValue());
                    fiscal.setNitCliente(fila.getCell(17).getStringCellValue());
                    fiscal.setDuiCliente(fila.getCell(18).getStringCellValue());
                    fiscal.setNrcCliente(fila.getCell(19).getStringCellValue());
                    fiscal.setCodigoCliente(Double.valueOf(fila.getCell(20).getNumericCellValue()).intValue());
                    fiscal.setNombreCliente(fila.getCell(21).getStringCellValue());
                    fiscal.setDireccionCliente(fila.getCell(22).getStringCellValue());
                    fiscal.setDepartamento(fila.getCell(23).getStringCellValue());
                    fiscal.setMunicipio(fila.getCell(24).getStringCellValue());
                    fiscal.setTelefono(String.valueOf(fila.getCell(26).getNumericCellValue()));
                    fiscal.setEmail(fila.getCell(27).getStringCellValue());
                    fiscal.setSms(String.valueOf(fila.getCell(28).getNumericCellValue()));
                    fiscal.setWhatsapp(String.valueOf(fila.getCell(29).getNumericCellValue()));
                    fiscal.setIdDepartamentoReceptor(Double.valueOf(fila.getCell(30).getNumericCellValue()).intValue());
                    fiscal.setIdMunicipioReceptor(Double.valueOf(fila.getCell(31).getNumericCellValue()).intValue());
                    fiscal.setCodigoActividadEconomica(Double.valueOf(fila.getCell(32).getNumericCellValue()).intValue());
                    fiscal.setTipoCatContribuyente(fila.getCell(33).getStringCellValue());
                    fiscal.setGiro(fila.getCell(34).getStringCellValue());
                    fiscal.setCodicionPago(Double.valueOf(fila.getCell(35).getNumericCellValue()).intValue());
                    fiscal.setCCFAnterior(fila.getCell(36).getStringCellValue());
                    fiscal.setVtaACuentaDe(fila.getCell(37).getStringCellValue());
                    fiscal.setNotaRemision(fila.getCell(38).getStringCellValue());
                    fiscal.setNoFecha(fila.getCell(39).getStringCellValue());
                    fiscal.setSaldoCapital(fila.getCell(40).getNumericCellValue());
                    fiscal.setDescripcion(fila.getCell(41).getStringCellValue());
                    fiscal.setPrecioUnitario(fila.getCell(42).getNumericCellValue());
                    fiscal.setVentasNoSujetas(fila.getCell(43).getNumericCellValue());
                    fiscal.setIvaItem(fila.getCell(44).getNumericCellValue());
                    fiscal.setDelAl(fila.getCell(45).getNumericCellValue());
                    fiscal.setExportaciones(Double.valueOf(fila.getCell(46).getNumericCellValue()).intValue());
                    fiscal.setNumDocRel(Double.valueOf(fila.getCell(47).getNumericCellValue()).intValue());
                    fiscal.setCodTributo(Double.valueOf(fila.getCell(48).getNumericCellValue()).intValue());
                    fiscal.setTributos(Double.valueOf(fila.getCell(49).getNumericCellValue()).intValue());
                    fiscal.setUniMedidaCodigo(Double.valueOf(fila.getCell(50).getNumericCellValue()).intValue());
                    fiscal.setVentasExentas(fila.getCell(51).getNumericCellValue());
                    fiscal.setFecha(fila.getCell(52).getStringCellValue());
                    fiscal.setTipoItem(Double.valueOf(fila.getCell(53).getNumericCellValue()).intValue());
                    fiscal.setTipoDteRel(Double.valueOf(fila.getCell(54).getNumericCellValue()).intValue());
                    fiscal.setCodigoRetencionMH(Double.valueOf(fila.getCell(55).getNumericCellValue()).intValue());
                    fiscal.setCantidad(Double.valueOf(fila.getCell(56).getNumericCellValue()).intValue());
                    fiscal.setVentasGravadas(Double.valueOf(fila.getCell(57).getNumericCellValue()).intValue());
                    fiscal.setIvaRetenido(fila.getCell(58).getNumericCellValue());
                    fiscal.setDescuento(fila.getCell(59).getNumericCellValue());
                    fiscal.setDescuentoItem(Double.valueOf(fila.getCell(60).getNumericCellValue()).intValue());
                    fiscal.setOtroMonNoAfec(Double.valueOf(fila.getCell(61).getNumericCellValue()).intValue());
                    fiscal.setMontoLetras(fila.getCell(62).getStringCellValue());
                    fiscal.setSumas(fila.getCell(63).getNumericCellValue());
                    fiscal.setSubTotalVentasExentas(fila.getCell(64).getNumericCellValue());
                    fiscal.setSubTotalVentasNoSujetas(fila.getCell(65).getNumericCellValue());
                    fiscal.setSubTotalVentasGravadas(fila.getCell(66).getNumericCellValue());
                    fiscal.setVentasGravada(fila.getCell(67).getNumericCellValue());
                    fiscal.setIva(fila.getCell(68).getNumericCellValue());
                    fiscal.setRenta(fila.getCell(69).getNumericCellValue());
                    fiscal.setImpuesto(fila.getCell(70).getNumericCellValue());
                    fiscal.setVentasExenta(fila.getCell(71).getNumericCellValue());
                    fiscal.setVentasNoSujeta(fila.getCell(72).getNumericCellValue());
                    fiscal.setCodigoTributo(fila.getCell(73).getNumericCellValue());
                    fiscal.setCodigoTributos(Double.valueOf(fila.getCell(74).getNumericCellValue()).intValue());
                    fiscal.setDescripcionTributo(fila.getCell(75).getStringCellValue());
                    fiscal.setValorTributo(fila.getCell(76).getNumericCellValue());
                    fiscal.setDescuentos(fila.getCell(77).getNumericCellValue());
                    fiscal.setAbonos(fila.getCell(78).getNumericCellValue());
                    fiscal.setCantidadTotal(Double.valueOf(fila.getCell(79).getNumericCellValue()).intValue());
                    fiscal.setVentaTotal(fila.getCell(80).getNumericCellValue());
                    fiscal.setVentasGravadas13(fila.getCell(81).getNumericCellValue());
                    fiscal.setVentasGravadas0(fila.getCell(82).getNumericCellValue());
                    fiscal.setVentasNoGravadas(fila.getCell(83).getNumericCellValue());
                    fiscal.setIvaPercibido1(fila.getCell(84).getNumericCellValue());
                    fiscal.setIvaPercibido2(fila.getCell(85).getNumericCellValue());
                    fiscal.setIvaRetenido1(fila.getCell(86).getNumericCellValue());
                    fiscal.setIvaRetenido13(fila.getCell(87).getNumericCellValue());
                    fiscal.setMontGDescVentNoSujetas(fila.getCell(88).getNumericCellValue());
                    fiscal.setMontGDescVentExentas(fila.getCell(89).getNumericCellValue());
                    fiscal.setMontGDescVentGrav(fila.getCell(90).getNumericCellValue());
                    fiscal.setTotOtroMonNoAfec(fila.getCell(91).getNumericCellValue());
                    fiscal.setTotalAPagar(fila.getCell(92).getNumericCellValue());
                    fiscal.setSeguro(fila.getCell(93).getNumericCellValue());
                    fiscal.setFlete(fila.getCell(94).getNumericCellValue());
                    fiscal.setContribucionSeguridad(fila.getCell(95).getNumericCellValue());
                    fiscal.setFovial(fila.getCell(96).getNumericCellValue());
                    fiscal.setCotrans(fila.getCell(97).getNumericCellValue());
                    fiscal.setContribucionTurismo5(fila.getCell(98).getNumericCellValue());
                    fiscal.setContribucionTurismo7(fila.getCell(99).getNumericCellValue());
                    fiscal.setImpuestoEspecifico(fila.getCell(100).getNumericCellValue());
                    fiscal.setCesc(fila.getCell(101).getNumericCellValue());
                    fiscal.setFormatodocumento(fila.getCell(119).getStringCellValue());
                    daoCreditoFiscal.insertCreditoFiscal(fiscal);
                    out.println("<h1>felicidades" + fiscal.getFormatodocumento() + "</h1>");
                } catch (Exception e) {

                }
            }

            Sheet sheet1 = wb.getSheetAt(1);
            int numeroFilas1 = sheet1.getLastRowNum();
            Row fila = sheet1.getRow(3);

            try {
                faturaConsumidorFinal fatConsFinal = new faturaConsumidorFinal();

                fatConsFinal.setNit(fila.getCell(0).getStringCellValue());
                fatConsFinal.setNrc(fila.getCell(1).getStringCellValue());
                fatConsFinal.setIdDepartamentoEmisor(Double.valueOf(fila.getCell(2).getNumericCellValue()).intValue());
                fatConsFinal.setIdMunicipioEmisor(Double.valueOf(fila.getCell(3).getNumericCellValue()).intValue());
                fatConsFinal.setDireccionEmisor(fila.getCell(4).getStringCellValue());
                Date date = fila.getCell(5).getDateCellValue();
                fatConsFinal.setFechaEnvio(dateFormat.format(date));
                date = fila.getCell(6).getDateCellValue();
                fatConsFinal.setFechaEmision(dateFormat.format(date));
                fatConsFinal.setTerminal(fila.getCell(7).getStringCellValue());
                fatConsFinal.setNumFactura(Double.valueOf(fila.getCell(8).getNumericCellValue()).intValue());
                fatConsFinal.setCorrelativoInterno(Double.valueOf(fila.getCell(9).getNumericCellValue()).intValue());
                fatConsFinal.setNumeroTransaccion(Double.valueOf(fila.getCell(10).getNumericCellValue()).intValue());
                fatConsFinal.setCodigoUsuario(Double.valueOf(fila.getCell(11).getNumericCellValue()).intValue());
                fatConsFinal.setNombreUsuario(fila.getCell(12).getStringCellValue());
                fatConsFinal.setCorreoUsuario(fila.getCell(13).getStringCellValue());
                fatConsFinal.setCajaSuc(fila.getCell(14).getStringCellValue());
                fatConsFinal.setTipoDocumento(fila.getCell(15).getStringCellValue());
                fatConsFinal.setPdv(fila.getCell(16).getStringCellValue());
                fatConsFinal.setNitCliente(String.valueOf((int) fila.getCell(17).getNumericCellValue()));
                fatConsFinal.setDuiCliente(fila.getCell(18).getStringCellValue());
                fatConsFinal.setNrcCliente(String.valueOf((int) fila.getCell(19).getNumericCellValue()));
                fatConsFinal.setCodigoCliente(Double.valueOf(fila.getCell(20).getNumericCellValue()).intValue());
                fatConsFinal.setNombreCliente(fila.getCell(21).getStringCellValue());
                fatConsFinal.setDireccionCliente(fila.getCell(22).getStringCellValue());
                fatConsFinal.setDepartamento(fila.getCell(23).getStringCellValue());
                fatConsFinal.setMunicipio(fila.getCell(24).getStringCellValue());
                fatConsFinal.setTelefono(String.valueOf(fila.getCell(26).getNumericCellValue()));
                fatConsFinal.setEmail(fila.getCell(27).getStringCellValue());
                fatConsFinal.setSms(String.valueOf(fila.getCell(28).getNumericCellValue()));
                fatConsFinal.setWhatsapp(String.valueOf(fila.getCell(29).getNumericCellValue()));
                fatConsFinal.setIdDepartamentoReceptor(Double.valueOf(fila.getCell(30).getNumericCellValue()).intValue());
                fatConsFinal.setIdMunicipioReceptor(Double.valueOf(fila.getCell(31).getNumericCellValue()).intValue());
                fatConsFinal.setCodigoActividadEconomica(Double.valueOf(fila.getCell(32).getNumericCellValue()).intValue());
                fatConsFinal.setTipoCatContribuyente(fila.getCell(33).getStringCellValue());
                fatConsFinal.setGiro(fila.getCell(34).getStringCellValue());
                fatConsFinal.setCodicionPago(Double.valueOf(fila.getCell(35).getNumericCellValue()).intValue());
                fatConsFinal.setCCFAnterior(fila.getCell(36).getStringCellValue());
                fatConsFinal.setVtaACuentaDe(fila.getCell(37).getStringCellValue());
                fatConsFinal.setNotaRemision(fila.getCell(38).getStringCellValue());
                fatConsFinal.setNoFecha(fila.getCell(39).getStringCellValue());
                fatConsFinal.setSaldoCapital(fila.getCell(40).getNumericCellValue());
                fatConsFinal.setDescripcion(fila.getCell(41).getStringCellValue());
                fatConsFinal.setPrecioUnitario(fila.getCell(42).getNumericCellValue());
                fatConsFinal.setVentasNoSujetas(fila.getCell(43).getNumericCellValue());
                fatConsFinal.setIvaItem(fila.getCell(44).getNumericCellValue());
                fatConsFinal.setDelAl(fila.getCell(45).getNumericCellValue());
                fatConsFinal.setExportaciones(Double.valueOf(fila.getCell(46).getNumericCellValue()).intValue());
                fatConsFinal.setNumDocRel(Double.valueOf(fila.getCell(47).getNumericCellValue()).intValue());
                fatConsFinal.setCodTributo(Double.valueOf(fila.getCell(48).getNumericCellValue()).intValue());
                fatConsFinal.setTributos(Double.valueOf(fila.getCell(49).getNumericCellValue()).intValue());
                fatConsFinal.setUniMedidaCodigo(Double.valueOf(fila.getCell(50).getNumericCellValue()).intValue());
                fatConsFinal.setVentasExentas(fila.getCell(51).getNumericCellValue());
                fatConsFinal.setFecha(fila.getCell(52).getStringCellValue());
                fatConsFinal.setTipoItem(Double.valueOf(fila.getCell(53).getNumericCellValue()).intValue());
                fatConsFinal.setTipoDteRel(Double.valueOf(fila.getCell(54).getNumericCellValue()).intValue());
                fatConsFinal.setCodigoRetencionMH(Double.valueOf(fila.getCell(55).getNumericCellValue()).intValue());
                fatConsFinal.setCantidad(Double.valueOf(fila.getCell(56).getNumericCellValue()).intValue());
                fatConsFinal.setVentasGravadas(Double.valueOf(fila.getCell(57).getNumericCellValue()).intValue());
                fatConsFinal.setIvaRetenido(fila.getCell(58).getNumericCellValue());
                fatConsFinal.setDescuento(fila.getCell(59).getNumericCellValue());
                fatConsFinal.setDescuentoItem(Double.valueOf(fila.getCell(60).getNumericCellValue()).intValue());
                fatConsFinal.setOtroMonNoAfec(Double.valueOf(fila.getCell(61).getNumericCellValue()).intValue());
                fatConsFinal.setMontoLetras(fila.getCell(62).getStringCellValue());
                fatConsFinal.setSumas(fila.getCell(63).getNumericCellValue());
                fatConsFinal.setSubTotalVentasExentas(fila.getCell(64).getNumericCellValue());
                fatConsFinal.setSubTotalVentasNoSujetas(fila.getCell(65).getNumericCellValue());
                fatConsFinal.setSubTotalVentasGravadas(fila.getCell(66).getNumericCellValue());
                fatConsFinal.setVentasGravada(fila.getCell(67).getNumericCellValue());
                fatConsFinal.setIva(fila.getCell(68).getNumericCellValue());
                fatConsFinal.setRenta(fila.getCell(69).getNumericCellValue());
                fatConsFinal.setImpuesto(fila.getCell(70).getNumericCellValue());
                fatConsFinal.setVentasExenta(fila.getCell(71).getNumericCellValue());
                fatConsFinal.setVentasNoSujeta(fila.getCell(72).getNumericCellValue());
                fatConsFinal.setCodigoTributo(fila.getCell(73).getNumericCellValue());
                fatConsFinal.setCodigoTributos(Double.valueOf(fila.getCell(74).getNumericCellValue()).intValue());
                fatConsFinal.setDescripcionTributo(String.valueOf((int) fila.getCell(75).getNumericCellValue()));
                fatConsFinal.setValorTributo(fila.getCell(76).getNumericCellValue());
                fatConsFinal.setDescuentos(fila.getCell(77).getNumericCellValue());
                fatConsFinal.setAbonos(fila.getCell(78).getNumericCellValue());
                fatConsFinal.setCantidadTotal(Double.valueOf(fila.getCell(79).getNumericCellValue()).intValue());
                fatConsFinal.setVentaTotal(fila.getCell(80).getNumericCellValue());
                fatConsFinal.setVentasGravadas13(fila.getCell(81).getNumericCellValue());
                fatConsFinal.setVentasGravadas0(fila.getCell(82).getNumericCellValue());
                fatConsFinal.setVentasNoGravadas(fila.getCell(83).getNumericCellValue());
                fatConsFinal.setIvaPercibido1(fila.getCell(84).getNumericCellValue());
                fatConsFinal.setIvaPercibido2(fila.getCell(85).getNumericCellValue());
                fatConsFinal.setIvaRetenido1(fila.getCell(86).getNumericCellValue());
                fatConsFinal.setIvaRetenido13(fila.getCell(87).getNumericCellValue());
                fatConsFinal.setMontGDescVentNoSujetas(fila.getCell(88).getNumericCellValue());
                fatConsFinal.setMontGDescVentExentas(fila.getCell(89).getNumericCellValue());
                fatConsFinal.setMontGDescVentGrav(fila.getCell(90).getNumericCellValue());
                fatConsFinal.setTotOtroMonNoAfec(fila.getCell(91).getNumericCellValue());
                fatConsFinal.setTotalAPagar(fila.getCell(92).getNumericCellValue());
                fatConsFinal.setSeguro(fila.getCell(93).getNumericCellValue());
                fatConsFinal.setFlete(fila.getCell(94).getNumericCellValue());
                fatConsFinal.setContribucionSeguridad(fila.getCell(95).getNumericCellValue());
                fatConsFinal.setFovial(fila.getCell(96).getNumericCellValue());
                fatConsFinal.setCotrans(fila.getCell(97).getNumericCellValue());
                fatConsFinal.setContribucionTurismo5(fila.getCell(98).getNumericCellValue());
                fatConsFinal.setContribucionTurismo7(fila.getCell(99).getNumericCellValue());
                fatConsFinal.setImpuestoEspecifico(fila.getCell(100).getNumericCellValue());
                fatConsFinal.setCesc(fila.getCell(101).getNumericCellValue());
                fatConsFinal.setFormatodocumento(fila.getCell(119).getStringCellValue());
                daoFaturaConsumidorFinal.insertFaturaConsumidorFinal(fatConsFinal);
                out.println("<h1>felicidades gg" + fatConsFinal.getFormatodocumento() + "</h1>");
            } catch (Exception e) {

            }
            response.sendRedirect("index.html");
        } else if (request.getParameter("btnGenerar") != null) {
            String outputFilePath = "C:\\Users\\josue\\Desktop\\Pasante\\creditoFiscal.json";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                for (creditoFiscal fiscal : daoCreditoFiscal.getCreditoFiscal()) {
                    JSONObject json = new JSONObject();
                    json.put("idCreditoFiscal", fiscal.getIdCreditoFiscal());
                    json.put("nit", fiscal.getNit());
                    json.put("nrc", fiscal.getNrc());
                    json.put("idDepartamentoEmisor", fiscal.getIdDepartamentoEmisor());
                    json.put("idMunicipioEmisor", fiscal.getIdMunicipioEmisor());
                    json.put("direccionEmisor", fiscal.getDireccionEmisor());
                    json.put("fechaEnvio", fiscal.getFechaEnvio());
                    json.put("fechaEmision", fiscal.getFechaEmision());
                    json.put("terminal", fiscal.getTerminal());
                    json.put("numFactura", fiscal.getNumFactura());
                    json.put("correlativoInterno", fiscal.getCorrelativoInterno());
                    json.put("numeroTransaccion", fiscal.getNumeroTransaccion());
                    json.put("codigoUsuario", fiscal.getCodigoUsuario());
                    json.put("nombreUsuario", fiscal.getNombreUsuario());
                    json.put("correoUsuario", fiscal.getCorreoUsuario());
                    json.put("cajaSuc", fiscal.getCajaSuc());
                    json.put("tipoDocumento", fiscal.getTipoDocumento());
                    json.put("pdv", fiscal.getPdv());
                    json.put("nitCliente", fiscal.getNitCliente());
                    json.put("duiCliente", fiscal.getDuiCliente());
                    json.put("nrcCliente", fiscal.getNrcCliente());
                    json.put("codigoCliente", fiscal.getCodigoCliente());
                    json.put("nombreCliente", fiscal.getNombreCliente());
                    json.put("direccionCliente", fiscal.getDireccionCliente());
                    json.put("departamento", fiscal.getDepartamento());
                    json.put("municipio", fiscal.getMunicipio());
                    json.put("telefono", fiscal.getTelefono());
                    json.put("email", fiscal.getEmail());
                    json.put("sms", fiscal.getSms());
                    json.put("whatsapp", fiscal.getWhatsapp());
                    json.put("idDepartamentoReceptor", fiscal.getIdDepartamentoReceptor());
                    json.put("idMunicipioReceptor", fiscal.getIdMunicipioReceptor());
                    json.put("codigoActividadEconomica", fiscal.getCodigoActividadEconomica());
                    json.put("tipoCatContribuyente", fiscal.getTipoCatContribuyente());
                    json.put("giro", fiscal.getGiro());
                    json.put("codicionPago", fiscal.getCodicionPago());
                    json.put("CCFAnterior", fiscal.getCCFAnterior());
                    json.put("vtaACuentaDe", fiscal.getVtaACuentaDe());
                    json.put("notaRemision", fiscal.getNotaRemision());
                    json.put("noFecha", fiscal.getNoFecha());
                    json.put("saldoCapital", fiscal.getSaldoCapital());
                    json.put("descripcion", fiscal.getDescripcion());
                    json.put("precioUnitario", fiscal.getPrecioUnitario());
                    json.put("ventasNoSujetas", fiscal.getVentasNoSujetas());
                    json.put("ivaItem", fiscal.getIvaItem());
                    json.put("delAl", fiscal.getDelAl());
                    json.put("exportaciones", fiscal.getExportaciones());
                    json.put("numDocRel", fiscal.getNumDocRel());
                    json.put("codTributo", fiscal.getCodTributo());
                    json.put("tributos", fiscal.getTributos());
                    json.put("uniMedidaCodigo", fiscal.getUniMedidaCodigo());
                    json.put("ventasExentas", fiscal.getVentasExentas());
                    json.put("fecha", fiscal.getFecha());
                    json.put("tipoItem", fiscal.getTipoItem());
                    json.put("tipoDteRel", fiscal.getTipoDteRel());
                    json.put("codigoRetencionMH", fiscal.getCodigoRetencionMH());
                    json.put("cantidad", fiscal.getCantidad());
                    json.put("ventasGravadas", fiscal.getVentasGravadas());
                    json.put("ivaRetenido", fiscal.getIvaRetenido());
                    json.put("descuento", fiscal.getDescuento());
                    json.put("descuentoItem", fiscal.getDescuentoItem());
                    json.put("otroMonNoAfec", fiscal.getOtroMonNoAfec());
                    json.put("montoLetras", fiscal.getMontoLetras());
                    json.put("sumas", fiscal.getSumas());
                    json.put("subTotalVentasExentas", fiscal.getSubTotalVentasExentas());
                    json.put("subTotalVentasNoSujetas", fiscal.getSubTotalVentasNoSujetas());
                    json.put("subTotalVentasGravadas", fiscal.getSubTotalVentasGravadas());
                    json.put("ventasGravada", fiscal.getVentasGravada());
                    json.put("iva", fiscal.getIva());
                    json.put("renta", fiscal.getRenta());
                    json.put("impuesto", fiscal.getImpuesto());
                    json.put("ventasExenta", fiscal.getVentasExenta());
                    json.put("ventasNoSujeta", fiscal.getVentasNoSujeta());
                    json.put("codigoTributo", fiscal.getCodigoTributo());
                    json.put("codigoTributos", fiscal.getCodigoTributos());
                    json.put("descripcionTributo", fiscal.getDescripcionTributo());
                    json.put("valorTributo", fiscal.getValorTributo());
                    json.put("descuentos", fiscal.getDescuentos());
                    json.put("abonos", fiscal.getAbonos());
                    json.put("cantidadTotal", fiscal.getCantidadTotal());
                    json.put("ventaTotal", fiscal.getVentaTotal());
                    json.put("ventasGravadas13", fiscal.getVentasGravadas13());
                    json.put("ventasGravadas0", fiscal.getVentasGravadas0());
                    json.put("ventasNoGravadas", fiscal.getVentasNoGravadas());
                    json.put("ivaPercibido1", fiscal.getIvaPercibido1());
                    json.put("ivaPercibido2", fiscal.getIvaPercibido2());
                    json.put("ivaRetenido1", fiscal.getIvaRetenido1());
                    json.put("ivaRetenido13", fiscal.getIvaRetenido13());
                    json.put("montGDescVentNoSujetas", fiscal.getMontGDescVentNoSujetas());
                    json.put("montGDescVentExentas", fiscal.getMontGDescVentExentas());
                    json.put("montGDescVentGrav", fiscal.getMontGDescVentGrav());
                    json.put("totOtroMonNoAfec", fiscal.getTotOtroMonNoAfec());
                    json.put("totalAPagar", fiscal.getTotalAPagar());
                    json.put("seguro", fiscal.getSeguro());
                    json.put("flete", fiscal.getFlete());
                    json.put("contribucionSeguridad", fiscal.getContribucionSeguridad());
                    json.put("fovial", fiscal.getFovial());
                    json.put("cotrans", fiscal.getCotrans());
                    json.put("contribucionTurismo5", fiscal.getContribucionTurismo5());
                    json.put("contribucionTurismo7", fiscal.getContribucionTurismo7());
                    json.put("impuestoEspecifico", fiscal.getImpuestoEspecifico());
                    json.put("cesc", fiscal.getCesc());
                    json.put("formatodocumento", fiscal.getFormatodocumento());

                    writer.write(json.toString());
                    writer.newLine();

                    String outputFilePath1 = "C:\\Users\\josue\\Desktop\\Pasante\\Pasante\\faturaConsumidorFinal.json";

                }

            } catch (Exception ex) {
                Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }  if (request.getParameter("btnGenerar") != null) {
            String outputFilePath1 = "C:\\Users\\josue\\Desktop\\Pasante\\faturaConsumidorFinal.json";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath1))) {
                for (faturaConsumidorFinal factConsurFinal : daoFaturaConsumidorFinal.getFaturaConsumidorFinal()) {
                    JSONObject json = new JSONObject();
                    json.put("idFacturaConsumidorFinal", factConsurFinal.getIdFacturaConsumidorFinal());
                    json.put("nit", factConsurFinal.getNit());
                    json.put("nrc", factConsurFinal.getNrc());
                    json.put("idDepartamentoEmisor", factConsurFinal.getIdDepartamentoEmisor());
                    json.put("idMunicipioEmisor", factConsurFinal.getIdMunicipioEmisor());
                    json.put("direccionEmisor", factConsurFinal.getDireccionEmisor());
                    json.put("fechaEnvio", factConsurFinal.getFechaEnvio());
                    json.put("fechaEmision", factConsurFinal.getFechaEmision());
                    json.put("terminal", factConsurFinal.getTerminal());
                    json.put("numFactura", factConsurFinal.getNumFactura());
                    json.put("correlativoInterno", factConsurFinal.getCorrelativoInterno());
                    json.put("numeroTransaccion", factConsurFinal.getNumeroTransaccion());
                    json.put("codigoUsuario", factConsurFinal.getCodigoUsuario());
                    json.put("nombreUsuario", factConsurFinal.getNombreUsuario());
                    json.put("correoUsuario", factConsurFinal.getCorreoUsuario());
                    json.put("cajaSuc", factConsurFinal.getCajaSuc());
                    json.put("tipoDocumento", factConsurFinal.getTipoDocumento());
                    json.put("pdv", factConsurFinal.getPdv());
                    json.put("nitCliente", factConsurFinal.getNitCliente());
                    json.put("duiCliente", factConsurFinal.getDuiCliente());
                    json.put("nrcCliente", factConsurFinal.getNrcCliente());
                    json.put("codigoCliente", factConsurFinal.getCodigoCliente());
                    json.put("nombreCliente", factConsurFinal.getNombreCliente());
                    json.put("direccionCliente", factConsurFinal.getDireccionCliente());
                    json.put("departamento", factConsurFinal.getDepartamento());
                    json.put("municipio", factConsurFinal.getMunicipio());
                    json.put("telefono", factConsurFinal.getTelefono());
                    json.put("email", factConsurFinal.getEmail());
                    json.put("sms", factConsurFinal.getSms());
                    json.put("whatsapp", factConsurFinal.getWhatsapp());
                    json.put("idDepartamentoReceptor", factConsurFinal.getIdDepartamentoReceptor());
                    json.put("idMunicipioReceptor", factConsurFinal.getIdMunicipioReceptor());
                    json.put("codigoActividadEconomica", factConsurFinal.getCodigoActividadEconomica());
                    json.put("tipoCatContribuyente", factConsurFinal.getTipoCatContribuyente());
                    json.put("giro", factConsurFinal.getGiro());
                    json.put("codicionPago", factConsurFinal.getCodicionPago());
                    json.put("CCFAnterior", factConsurFinal.getCCFAnterior());
                    json.put("vtaACuentaDe", factConsurFinal.getVtaACuentaDe());
                    json.put("notaRemision", factConsurFinal.getNotaRemision());
                    json.put("noFecha", factConsurFinal.getNoFecha());
                    json.put("saldoCapital", factConsurFinal.getSaldoCapital());
                    json.put("descripcion", factConsurFinal.getDescripcion());
                    json.put("precioUnitario", factConsurFinal.getPrecioUnitario());
                    json.put("ventasNoSujetas", factConsurFinal.getVentasNoSujetas());
                    json.put("ivaItem", factConsurFinal.getIvaItem());
                    json.put("delAl", factConsurFinal.getDelAl());
                    json.put("exportaciones", factConsurFinal.getExportaciones());
                    json.put("numDocRel", factConsurFinal.getNumDocRel());
                    json.put("codTributo", factConsurFinal.getCodTributo());
                    json.put("tributos", factConsurFinal.getTributos());
                    json.put("uniMedidaCodigo", factConsurFinal.getUniMedidaCodigo());
                    json.put("ventasExentas", factConsurFinal.getVentasExentas());
                    json.put("fecha", factConsurFinal.getFecha());
                    json.put("tipoItem", factConsurFinal.getTipoItem());
                    json.put("tipoDteRel", factConsurFinal.getTipoDteRel());
                    json.put("codigoRetencionMH", factConsurFinal.getCodigoRetencionMH());
                    json.put("cantidad", factConsurFinal.getCantidad());
                    json.put("ventasGravadas", factConsurFinal.getVentasGravadas());
                    json.put("ivaRetenido", factConsurFinal.getIvaRetenido());
                    json.put("descuento", factConsurFinal.getDescuento());
                    json.put("descuentoItem", factConsurFinal.getDescuentoItem());
                    json.put("otroMonNoAfec", factConsurFinal.getOtroMonNoAfec());
                    json.put("montoLetras", factConsurFinal.getMontoLetras());
                    json.put("sumas", factConsurFinal.getSumas());
                    json.put("subTotalVentasExentas", factConsurFinal.getSubTotalVentasExentas());
                    json.put("subTotalVentasNoSujetas", factConsurFinal.getSubTotalVentasNoSujetas());
                    json.put("subTotalVentasGravadas", factConsurFinal.getSubTotalVentasGravadas());
                    json.put("ventasGravada", factConsurFinal.getVentasGravada());
                    json.put("iva", factConsurFinal.getIva());
                    json.put("renta", factConsurFinal.getRenta());
                    json.put("impuesto", factConsurFinal.getImpuesto());
                    json.put("ventasExenta", factConsurFinal.getVentasExenta());
                    json.put("ventasNoSujeta", factConsurFinal.getVentasNoSujeta());
                    json.put("codigoTributo", factConsurFinal.getCodigoTributo());
                    json.put("codigoTributos", factConsurFinal.getCodigoTributos());
                    json.put("descripcionTributo", factConsurFinal.getDescripcionTributo());
                    json.put("valorTributo", factConsurFinal.getValorTributo());
                    json.put("descuentos", factConsurFinal.getDescuentos());
                    json.put("abonos", factConsurFinal.getAbonos());
                    json.put("cantidadTotal", factConsurFinal.getCantidadTotal());
                    json.put("ventaTotal", factConsurFinal.getVentaTotal());
                    json.put("ventasGravadas13", factConsurFinal.getVentasGravadas13());
                    json.put("ventasGravadas0", factConsurFinal.getVentasGravadas0());
                    json.put("ventasNoGravadas", factConsurFinal.getVentasNoGravadas());
                    json.put("ivaPercibido1", factConsurFinal.getIvaPercibido1());
                    json.put("ivaPercibido2", factConsurFinal.getIvaPercibido2());
                    json.put("ivaRetenido1", factConsurFinal.getIvaRetenido1());
                    json.put("ivaRetenido13", factConsurFinal.getIvaRetenido13());
                    json.put("montGDescVentNoSujetas", factConsurFinal.getMontGDescVentNoSujetas());
                    json.put("montGDescVentExentas", factConsurFinal.getMontGDescVentExentas());
                    json.put("montGDescVentGrav", factConsurFinal.getMontGDescVentGrav());
                    json.put("totOtroMonNoAfec", factConsurFinal.getTotOtroMonNoAfec());
                    json.put("totalAPagar", factConsurFinal.getTotalAPagar());
                    json.put("seguro", factConsurFinal.getSeguro());
                    json.put("flete", factConsurFinal.getFlete());
                    json.put("contribucionSeguridad", factConsurFinal.getContribucionSeguridad());
                    json.put("fovial", factConsurFinal.getFovial());
                    json.put("cotrans", factConsurFinal.getCotrans());
                    json.put("contribucionTurismo5", factConsurFinal.getContribucionTurismo5());
                    json.put("contribucionTurismo7", factConsurFinal.getContribucionTurismo7());
                    json.put("impuestoEspecifico", factConsurFinal.getImpuestoEspecifico());
                    json.put("cesc", factConsurFinal.getCesc());
                    json.put("formatodocumento", factConsurFinal.getFormatodocumento());
                    
                    writer.write(json.toString());
                    writer.newLine();
                }

            } catch (Exception ex) {
                Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("index.html");
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
