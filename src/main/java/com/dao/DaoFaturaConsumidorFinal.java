
package com.dao;

import com.conexion.Conexion;
import com.modelo.faturaConsumidorFinal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class DaoFaturaConsumidorFinal extends Conexion {
    
    public List<faturaConsumidorFinal> getFaturaConsumidorFinal() throws Exception {
        ResultSet rs;
        List<faturaConsumidorFinal> lst = new ArrayList();
        try {
            this.conectar();
            String sql = "SELECT * FROM faturaConsumidorFinal";
            PreparedStatement pst = (PreparedStatement) this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                faturaConsumidorFinal fatConsuFinal = new faturaConsumidorFinal();
                fatConsuFinal.setIdFacturaConsumidorFinal(rs.getInt("idfaturaConsumidorFinal"));
                fatConsuFinal.setNit(rs.getString("nit"));
                fatConsuFinal.setNrc(rs.getString("nrc"));
                fatConsuFinal.setIdDepartamentoEmisor(rs.getInt("idDepartamentoEmisor"));
                fatConsuFinal.setMunicipio(rs.getString("idMunicipioEmisor"));
                fatConsuFinal.setDireccionEmisor(rs.getString("direccionEmisor"));
                fatConsuFinal.setFechaEnvio(rs.getString("fechaEnvio"));
                fatConsuFinal.setFechaEmision(rs.getString("fechaEmision"));
                fatConsuFinal.setTerminal(rs.getString("terminal"));
                fatConsuFinal.setNumFactura(rs.getInt("numFactura"));
                fatConsuFinal.setCorrelativoInterno(rs.getInt("correlativoInterno"));
                fatConsuFinal.setNumeroTransaccion(rs.getInt("numeroTransaccion"));
                fatConsuFinal.setCodigoUsuario(rs.getInt("codigoUsuario"));
                fatConsuFinal.setNombreUsuario(rs.getString("nombreUsuario"));
                fatConsuFinal.setCorreoUsuario(rs.getString("correoUsuario"));
                fatConsuFinal.setCajaSuc(rs.getString("cajaSuc"));
                fatConsuFinal.setTipoDocumento(rs.getString("tipoDocumento"));
                fatConsuFinal.setPdv(rs.getString("pdv"));
                fatConsuFinal.setNitCliente(rs.getString("nitCliente"));
                fatConsuFinal.setDuiCliente(rs.getString("duiCliente"));
                fatConsuFinal.setNrcCliente(rs.getString("nrcCliente"));
                fatConsuFinal.setCodigoCliente(rs.getInt("codigoCliente"));
                fatConsuFinal.setNombreCliente(rs.getString("nombreCliente"));
                fatConsuFinal.setDireccionCliente(rs.getString("direccionCliente"));
                fatConsuFinal.setDepartamento(rs.getString("departamento"));           
                fatConsuFinal.setMunicipio(rs.getString("municipio"));
                fatConsuFinal.setTelefono(rs.getString("telefono"));
                fatConsuFinal.setEmail(rs.getString("email")); 
                fatConsuFinal.setSms(rs.getString("sms"));
                fatConsuFinal.setWhatsapp(rs.getString("whatsapp"));
                fatConsuFinal.setIdDepartamentoReceptor(rs.getInt("idDepartamentoReceptor"));
                fatConsuFinal.setIdMunicipioReceptor(rs.getInt("idMunicipioReceptor"));
                fatConsuFinal.setCodigoActividadEconomica(rs.getInt("codigoActividadEconomica"));
                fatConsuFinal.setTipoCatContribuyente(rs.getString("tipoCatContribuyente")); 
                fatConsuFinal.setGiro(rs.getString("giro")); 
                fatConsuFinal.setCodicionPago(rs.getInt("codicionPago")); 
                fatConsuFinal.setCCFAnterior(rs.getString("CCFAnterior")); 
                fatConsuFinal.setVtaACuentaDe(rs.getString("vtaACuentaDe")); 
                fatConsuFinal.setNotaRemision(rs.getString("notaRemision")); 
                fatConsuFinal.setNoFecha(rs.getString("noFecha")); 
                fatConsuFinal.setSaldoCapital(rs.getDouble("saldoCapital"));
                fatConsuFinal.setDescripcion(rs.getString("descripcion")); 
                fatConsuFinal.setPrecioUnitario(rs.getDouble("precioUnitario"));
                fatConsuFinal.setVentasNoSujetas(rs.getDouble("ventasNoSujetas"));
                fatConsuFinal.setIvaItem(rs.getDouble("ivaItem"));
                fatConsuFinal.setDelAl(rs.getDouble("delAl"));
                fatConsuFinal.setExportaciones(rs.getInt("exportaciones")); 
                fatConsuFinal.setNumDocRel(rs.getInt("numDocRel")); 
                fatConsuFinal.setCodTributo(rs.getInt("codTributo")); 
                fatConsuFinal.setTributos(rs.getInt("tributos")); 
                fatConsuFinal.setUniMedidaCodigo(rs.getInt("uniMedidaCodigo")); 
                fatConsuFinal.setVentasExentas(rs.getDouble("ventasExentas"));
                fatConsuFinal.setFecha(rs.getString("fecha"));
                fatConsuFinal.setTipoItem(rs.getInt("tipoItem")); 
                fatConsuFinal.setTipoDteRel(rs.getInt("tipoDteRel")); 
                fatConsuFinal.setCodigoRetencionMH(rs.getInt("codigoRetencionMH")); 
                fatConsuFinal.setCantidad(rs.getInt("cantidad")); 
                fatConsuFinal.setVentasGravadas(rs.getInt("ventasGravadas")); 
                fatConsuFinal.setIvaRetenido(rs.getDouble("ivaRetenido"));
                fatConsuFinal.setDescuento(rs.getDouble("descuento"));
                fatConsuFinal.setDescuentoItem(rs.getInt("descuentoItem")); 
                fatConsuFinal.setOtroMonNoAfec(rs.getInt("otroMonNoAfec")); 
                fatConsuFinal.setMontoLetras(rs.getString("montoLetras")); 
                fatConsuFinal.setSumas(rs.getDouble("sumas"));
                fatConsuFinal.setSubTotalVentasExentas(rs.getDouble("subTotalVentasExentas"));
                fatConsuFinal.setSubTotalVentasNoSujetas(rs.getDouble("subTotalVentasNoSujetas"));
                fatConsuFinal.setSubTotalVentasGravadas(rs.getDouble("subTotalVentasGravadas"));
                fatConsuFinal.setVentasGravada(rs.getDouble("ventasGravada"));
                fatConsuFinal.setIva(rs.getDouble("iva"));
                fatConsuFinal.setRenta(rs.getDouble("renta"));
                fatConsuFinal.setImpuesto(rs.getDouble("impuesto"));
                fatConsuFinal.setVentasExenta(rs.getDouble("ventasExenta"));
                fatConsuFinal.setVentasNoSujeta(rs.getDouble("ventasNoSujeta"));
                fatConsuFinal.setCodigoTributo(rs.getDouble("codigoTributo"));
                fatConsuFinal.setCodigoTributos(rs.getInt("codigoTributos"));
                fatConsuFinal.setDescripcionTributo(rs.getString("descripcionTributo")); 
                fatConsuFinal.setValorTributo(rs.getDouble("valorTributo"));
                fatConsuFinal.setDescuentos(rs.getDouble("descuentos"));
                fatConsuFinal.setAbonos(rs.getDouble("abonos"));
                fatConsuFinal.setCantidadTotal(rs.getInt("cantidadTotal"));
                fatConsuFinal.setVentaTotal(rs.getDouble("ventaTotal"));
                fatConsuFinal.setVentasGravadas13(rs.getDouble("ventasGravadas13"));
                fatConsuFinal.setVentasGravadas0(rs.getDouble("ventasGravadas0"));
                fatConsuFinal.setVentasNoGravadas(rs.getDouble("ventasNoGravadas"));
                fatConsuFinal.setIvaPercibido1(rs.getDouble("ivaPercibido1"));
                fatConsuFinal.setIvaPercibido2(rs.getDouble("ivaPercibido2"));
                fatConsuFinal.setIvaRetenido1(rs.getDouble("ivaRetenido1"));
                fatConsuFinal.setIvaRetenido13(rs.getDouble("ivaRetenido13"));
                fatConsuFinal.setMontGDescVentNoSujetas(rs.getDouble("montGDescVentNoSujetas"));
                fatConsuFinal.setMontGDescVentExentas(rs.getDouble("montGDescVentExentas"));
                fatConsuFinal.setMontGDescVentGrav(rs.getDouble("montGDescVentGrav"));
                fatConsuFinal.setTotOtroMonNoAfec(rs.getDouble("totOtroMonNoAfec"));
                fatConsuFinal.setTotalAPagar(rs.getDouble("totalAPagar"));
                fatConsuFinal.setSeguro(rs.getDouble("seguro"));
                fatConsuFinal.setFlete(rs.getDouble("flete"));
                fatConsuFinal.setContribucionSeguridad(rs.getDouble("contribucionSeguridad"));
                fatConsuFinal.setFovial(rs.getDouble("fovial"));
                fatConsuFinal.setCotrans(rs.getDouble("cotrans"));
                fatConsuFinal.setContribucionTurismo5(rs.getDouble("contribucionTurismo5"));
                fatConsuFinal.setContribucionTurismo7(rs.getDouble("contribucionTurismo7"));
                fatConsuFinal.setImpuestoEspecifico(rs.getDouble("impuestoEspecifico"));
                fatConsuFinal.setCesc(rs.getDouble("cesc"));
                fatConsuFinal.setFormatodocumento(rs.getString("formatodocumento")); 
                lst.add(fatConsuFinal);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lst;
    }
    public void insertFaturaConsumidorFinal(faturaConsumidorFinal fatConsuFinal) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT  INTO  faturaConsumidorFinal values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1,fatConsuFinal.getNit());
            pst.setString(2,fatConsuFinal.getNrc());
            pst.setInt(3,fatConsuFinal.getIdDepartamentoEmisor());
            pst.setInt(4,fatConsuFinal.getIdMunicipioEmisor());
            pst.setString(5,fatConsuFinal.getDireccionEmisor());
            pst.setString(6,fatConsuFinal.getFechaEnvio());
            pst.setString(7,fatConsuFinal.getFechaEmision());
            pst.setString(8,fatConsuFinal.getTerminal());
            pst.setInt(9,fatConsuFinal.getNumFactura());
            pst.setInt(10,fatConsuFinal.getCorrelativoInterno());
            pst.setInt(11,fatConsuFinal.getNumeroTransaccion());
            pst.setInt(12,fatConsuFinal.getCodigoUsuario());
            pst.setString(13,fatConsuFinal.getNombreUsuario());
            pst.setString(14,fatConsuFinal.getCorreoUsuario());
            pst.setString(15,fatConsuFinal.getCajaSuc());
            pst.setString(16,fatConsuFinal.getTipoDocumento());
            pst.setString(17,fatConsuFinal.getPdv());
            pst.setString(18,fatConsuFinal.getNitCliente());
            pst.setString(19,fatConsuFinal.getDuiCliente());
            pst.setString(20,fatConsuFinal.getNrcCliente());
            pst.setInt(21,fatConsuFinal.getCodigoCliente());
            pst.setString(22,fatConsuFinal.getNombreCliente());
            pst.setString(23,fatConsuFinal.getDireccionCliente());
            pst.setString(24,fatConsuFinal.getDepartamento());           
            pst.setString(25,fatConsuFinal.getMunicipio());
            pst.setString(26,fatConsuFinal.getTelefono());
            pst.setString(27,fatConsuFinal.getEmail()); 
            pst.setString(28,fatConsuFinal.getSms());
            pst.setString(29,fatConsuFinal.getWhatsapp());
            pst.setInt(30,fatConsuFinal.getIdDepartamentoReceptor());
            pst.setInt(31,fatConsuFinal.getIdMunicipioReceptor());
            pst.setInt(32,fatConsuFinal.getCodigoActividadEconomica());
            pst.setString(33,fatConsuFinal.getTipoCatContribuyente()); 
            pst.setString(34,fatConsuFinal.getGiro()); 
            pst.setInt(35,fatConsuFinal.getCodicionPago()); 
            pst.setString(36,fatConsuFinal.getCCFAnterior()); 
            pst.setString(37,fatConsuFinal.getVtaACuentaDe()); 
            pst.setString(38,fatConsuFinal.getNotaRemision()); 
            pst.setString(39,fatConsuFinal.getNoFecha()); 
            pst.setDouble(40,fatConsuFinal.getSaldoCapital());
            pst.setString(41,fatConsuFinal.getDescripcion()); 
            pst.setDouble(42,fatConsuFinal.getPrecioUnitario());
            pst.setDouble(43,fatConsuFinal.getVentasNoSujetas());
            pst.setDouble(44,fatConsuFinal.getIvaItem());
            pst.setDouble(45,fatConsuFinal.getDelAl());
            pst.setInt(46,fatConsuFinal.getExportaciones()); 
            pst.setInt(47,fatConsuFinal.getNumDocRel()); 
            pst.setInt(48,fatConsuFinal.getCodTributo()); 
            pst.setDouble(49,fatConsuFinal.getTributos()); 
            pst.setInt(50,fatConsuFinal.getUniMedidaCodigo()); 
            pst.setDouble(51,fatConsuFinal.getVentasExentas());
            pst.setString(52,fatConsuFinal.getFecha());
            pst.setInt(53,fatConsuFinal.getTipoItem()); 
            pst.setInt(54,fatConsuFinal.getTipoDteRel()); 
            pst.setInt(55,fatConsuFinal.getCodigoRetencionMH()); 
            pst.setInt(56,fatConsuFinal.getCantidad()); 
            pst.setInt(57,fatConsuFinal.getVentasGravadas()); 
            pst.setDouble(58,fatConsuFinal.getIvaRetenido());
            pst.setDouble(59,fatConsuFinal.getDescuento());
            pst.setInt(60,fatConsuFinal.getDescuentoItem()); 
            pst.setDouble(61,fatConsuFinal.getOtroMonNoAfec()); 
            pst.setString(62,fatConsuFinal.getMontoLetras()); 
            pst.setDouble(63,fatConsuFinal.getSumas());
            pst.setDouble(64,fatConsuFinal.getSubTotalVentasExentas());
            pst.setDouble(65,fatConsuFinal.getSubTotalVentasNoSujetas());
            pst.setDouble(66,fatConsuFinal.getSubTotalVentasGravadas());
            pst.setDouble(67,fatConsuFinal.getVentasGravada());
            pst.setDouble(68,fatConsuFinal.getIva());
            pst.setDouble(69,fatConsuFinal.getRenta());
            pst.setDouble(70,fatConsuFinal.getImpuesto());
            pst.setDouble(71,fatConsuFinal.getVentasExenta());
            pst.setDouble(72,fatConsuFinal.getVentasNoSujeta());
            pst.setDouble(73,fatConsuFinal.getCodigoTributo());
            pst.setInt(74,fatConsuFinal.getCodigoTributos());
            pst.setString(75,fatConsuFinal.getDescripcionTributo()); 
            pst.setDouble(76,fatConsuFinal.getValorTributo());
            pst.setDouble(77,fatConsuFinal.getDescuentos());
            pst.setDouble(78,fatConsuFinal.getAbonos());
            pst.setInt(79,fatConsuFinal.getCantidadTotal());
            pst.setDouble(80,fatConsuFinal.getVentaTotal());
            pst.setDouble(81,fatConsuFinal.getVentasGravadas13());
            pst.setDouble(82,fatConsuFinal.getVentasGravadas0());
            pst.setDouble(83,fatConsuFinal.getVentasNoGravadas());
            pst.setDouble(84,fatConsuFinal.getIvaPercibido1());
            pst.setDouble(85,fatConsuFinal.getIvaPercibido2());
            pst.setDouble(86,fatConsuFinal.getIvaRetenido1());
            pst.setDouble(87,fatConsuFinal.getIvaRetenido13());
            pst.setDouble(88,fatConsuFinal.getMontGDescVentNoSujetas());
            pst.setDouble(89,fatConsuFinal.getMontGDescVentExentas());
            pst.setDouble(90,fatConsuFinal.getMontGDescVentGrav());
            pst.setDouble(91,fatConsuFinal.getTotOtroMonNoAfec());
            pst.setDouble(92,fatConsuFinal.getTotalAPagar());
            pst.setDouble(93,fatConsuFinal.getSeguro());
            pst.setDouble(94,fatConsuFinal.getFlete());
            pst.setDouble(95,fatConsuFinal.getContribucionSeguridad());
            pst.setDouble(96,fatConsuFinal.getFovial());
            pst.setDouble(97,fatConsuFinal.getCotrans());
            pst.setDouble(98,fatConsuFinal.getContribucionTurismo5());
            pst.setDouble(99,fatConsuFinal.getContribucionTurismo7());
            pst.setDouble(100,fatConsuFinal.getImpuestoEspecifico());
            pst.setDouble(101,fatConsuFinal.getCesc());
            pst.setString(102,fatConsuFinal.getFormatodocumento()); 
            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
}
