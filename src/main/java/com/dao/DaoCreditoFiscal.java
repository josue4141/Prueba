
package com.dao;

import com.conexion.Conexion;
import com.modelo.creditoFiscal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class DaoCreditoFiscal extends Conexion {
    
    public List<creditoFiscal> getCreditoFiscal() throws Exception {
        ResultSet rs;
        List<creditoFiscal> lst = new ArrayList();
        try {
            this.conectar();
            String sql = "SELECT * FROM creditoFiscal";
            PreparedStatement pst = (PreparedStatement) this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                creditoFiscal fiscal = new creditoFiscal();
                fiscal.setIdCreditoFiscal(rs.getInt("IdCreditoFiscal"));
                fiscal.setNit(rs.getString("nit"));
                fiscal.setNrc(rs.getString("nrc"));
                fiscal.setIdDepartamentoEmisor(rs.getInt("idDepartamentoEmisor"));
                fiscal.setMunicipio(rs.getString("idMunicipioEmisor"));
                fiscal.setDireccionEmisor(rs.getString("direccionEmisor"));
                fiscal.setFechaEnvio(rs.getString("fechaEnvio"));
                fiscal.setFechaEmision(rs.getString("fechaEmision"));
                fiscal.setTerminal(rs.getString("terminal"));
                fiscal.setNumFactura(rs.getInt("numFactura"));
                fiscal.setCorrelativoInterno(rs.getInt("correlativoInterno"));
                fiscal.setNumeroTransaccion(rs.getInt("numeroTransaccion"));
                fiscal.setCodigoUsuario(rs.getInt("codigoUsuario"));
                fiscal.setNombreUsuario(rs.getString("nombreUsuario"));
                fiscal.setCorreoUsuario(rs.getString("correoUsuario"));
                fiscal.setCajaSuc(rs.getString("cajaSuc"));
                fiscal.setTipoDocumento(rs.getString("tipoDocumento"));
                fiscal.setPdv(rs.getString("pdv"));
                fiscal.setNitCliente(rs.getString("nitCliente"));
                fiscal.setDuiCliente(rs.getString("duiCliente"));
                fiscal.setNrcCliente(rs.getString("nrcCliente"));
                fiscal.setCodigoCliente(rs.getInt("codigoCliente"));
                fiscal.setNombreCliente(rs.getString("nombreCliente"));
                fiscal.setDireccionCliente(rs.getString("direccionCliente"));
                fiscal.setDepartamento(rs.getString("departamento"));           
                fiscal.setMunicipio(rs.getString("municipio"));
                fiscal.setTelefono(rs.getString("telefono"));
                fiscal.setEmail(rs.getString("email")); 
                fiscal.setSms(rs.getString("sms"));
                fiscal.setWhatsapp(rs.getString("whatsapp"));
                fiscal.setIdDepartamentoReceptor(rs.getInt("idDepartamentoReceptor"));
                fiscal.setIdMunicipioReceptor(rs.getInt("idMunicipioReceptor"));
                fiscal.setCodigoActividadEconomica(rs.getInt("codigoActividadEconomica"));
                fiscal.setTipoCatContribuyente(rs.getString("tipoCatContribuyente")); 
                fiscal.setGiro(rs.getString("giro")); 
                fiscal.setCodicionPago(rs.getInt("codicionPago")); 
                fiscal.setCCFAnterior(rs.getString("CCFAnterior")); 
                fiscal.setVtaACuentaDe(rs.getString("vtaACuentaDe")); 
                fiscal.setNotaRemision(rs.getString("notaRemision")); 
                fiscal.setNoFecha(rs.getString("noFecha")); 
                fiscal.setSaldoCapital(rs.getDouble("saldoCapital"));
                fiscal.setDescripcion(rs.getString("descripcion")); 
                fiscal.setPrecioUnitario(rs.getDouble("precioUnitario"));
                fiscal.setVentasNoSujetas(rs.getDouble("ventasNoSujetas"));
                fiscal.setIvaItem(rs.getDouble("ivaItem"));
                fiscal.setDelAl(rs.getDouble("delAl"));
                fiscal.setExportaciones(rs.getInt("exportaciones")); 
                fiscal.setNumDocRel(rs.getInt("numDocRel")); 
                fiscal.setCodTributo(rs.getInt("codTributo")); 
                fiscal.setTributos(rs.getInt("tributos")); 
                fiscal.setUniMedidaCodigo(rs.getInt("uniMedidaCodigo")); 
                fiscal.setVentasExentas(rs.getDouble("ventasExentas"));
                fiscal.setFecha(rs.getString("fecha"));
                fiscal.setTipoItem(rs.getInt("tipoItem")); 
                fiscal.setTipoDteRel(rs.getInt("tipoDteRel")); 
                fiscal.setCodigoRetencionMH(rs.getInt("codigoRetencionMH")); 
                fiscal.setCantidad(rs.getInt("cantidad")); 
                fiscal.setVentasGravadas(rs.getInt("ventasGravadas")); 
                fiscal.setIvaRetenido(rs.getDouble("ivaRetenido"));
                fiscal.setDescuento(rs.getDouble("descuento"));
                fiscal.setDescuentoItem(rs.getInt("descuentoItem")); 
                fiscal.setOtroMonNoAfec(rs.getInt("otroMonNoAfec")); 
                fiscal.setMontoLetras(rs.getString("montoLetras")); 
                fiscal.setSumas(rs.getDouble("sumas"));
                fiscal.setSubTotalVentasExentas(rs.getDouble("subTotalVentasExentas"));
                fiscal.setSubTotalVentasNoSujetas(rs.getDouble("subTotalVentasNoSujetas"));
                fiscal.setSubTotalVentasGravadas(rs.getDouble("subTotalVentasGravadas"));
                fiscal.setVentasGravada(rs.getDouble("ventasGravada"));
                fiscal.setIva(rs.getDouble("iva"));
                fiscal.setRenta(rs.getDouble("renta"));
                fiscal.setImpuesto(rs.getDouble("impuesto"));
                fiscal.setVentasExenta(rs.getDouble("ventasExenta"));
                fiscal.setVentasNoSujeta(rs.getDouble("ventasNoSujeta"));
                fiscal.setCodigoTributo(rs.getDouble("codigoTributo"));
                fiscal.setCodigoTributos(rs.getInt("codigoTributos"));
                fiscal.setDescripcionTributo(rs.getString("descripcionTributo")); 
                fiscal.setValorTributo(rs.getDouble("valorTributo"));
                fiscal.setDescuentos(rs.getDouble("descuentos"));
                fiscal.setAbonos(rs.getDouble("abonos"));
                fiscal.setCantidadTotal(rs.getInt("cantidadTotal"));
                fiscal.setVentaTotal(rs.getDouble("ventaTotal"));
                fiscal.setVentasGravadas13(rs.getDouble("ventasGravadas13"));
                fiscal.setVentasGravadas0(rs.getDouble("ventasGravadas0"));
                fiscal.setVentasNoGravadas(rs.getDouble("ventasNoGravadas"));
                fiscal.setIvaPercibido1(rs.getDouble("ivaPercibido1"));
                fiscal.setIvaPercibido2(rs.getDouble("ivaPercibido2"));
                fiscal.setIvaRetenido1(rs.getDouble("ivaRetenido1"));
                fiscal.setIvaRetenido13(rs.getDouble("ivaRetenido13"));
                fiscal.setMontGDescVentNoSujetas(rs.getDouble("montGDescVentNoSujetas"));
                fiscal.setMontGDescVentExentas(rs.getDouble("montGDescVentExentas"));
                fiscal.setMontGDescVentGrav(rs.getDouble("montGDescVentGrav"));
                fiscal.setTotOtroMonNoAfec(rs.getDouble("totOtroMonNoAfec"));
                fiscal.setTotalAPagar(rs.getDouble("totalAPagar"));
                fiscal.setSeguro(rs.getDouble("seguro"));
                fiscal.setFlete(rs.getDouble("flete"));
                fiscal.setContribucionSeguridad(rs.getDouble("contribucionSeguridad"));
                fiscal.setFovial(rs.getDouble("fovial"));
                fiscal.setCotrans(rs.getDouble("cotrans"));
                fiscal.setContribucionTurismo5(rs.getDouble("contribucionTurismo5"));
                fiscal.setContribucionTurismo7(rs.getDouble("contribucionTurismo7"));
                fiscal.setImpuestoEspecifico(rs.getDouble("impuestoEspecifico"));
                fiscal.setCesc(rs.getDouble("cesc"));
                fiscal.setFormatodocumento(rs.getString("formatodocumento")); 
                lst.add(fiscal);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lst;
    }
    public void insertCreditoFiscal(creditoFiscal fiscal) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT  INTO  creditoFiscal values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1,fiscal.getNit());
            pst.setString(2,fiscal.getNrc());
            pst.setInt(3,fiscal.getIdDepartamentoEmisor());
            pst.setInt(4,fiscal.getIdMunicipioEmisor());
            pst.setString(5,fiscal.getDireccionEmisor());
            pst.setString(6,fiscal.getFechaEnvio());
            pst.setString(7,fiscal.getFechaEmision());
            pst.setString(8,fiscal.getTerminal());
            pst.setInt(9,fiscal.getNumFactura());
            pst.setInt(10,fiscal.getCorrelativoInterno());
            pst.setInt(11,fiscal.getNumeroTransaccion());
            pst.setInt(12,fiscal.getCodigoUsuario());
            pst.setString(13,fiscal.getNombreUsuario());
            pst.setString(14,fiscal.getCorreoUsuario());
            pst.setString(15,fiscal.getCajaSuc());
            pst.setString(16,fiscal.getTipoDocumento());
            pst.setString(17,fiscal.getPdv());
            pst.setString(18,fiscal.getNitCliente());
            pst.setString(19,fiscal.getDuiCliente());
            pst.setString(20,fiscal.getNrcCliente());
            pst.setInt(21,fiscal.getCodigoCliente());
            pst.setString(22,fiscal.getNombreCliente());
            pst.setString(23,fiscal.getDireccionCliente());
            pst.setString(24,fiscal.getDepartamento());           
            pst.setString(25,fiscal.getMunicipio());
            pst.setString(26,fiscal.getTelefono());
            pst.setString(27,fiscal.getEmail()); 
            pst.setString(28,fiscal.getSms());
            pst.setString(29,fiscal.getWhatsapp());
            pst.setInt(30,fiscal.getIdDepartamentoReceptor());
            pst.setInt(31,fiscal.getIdMunicipioReceptor());
            pst.setInt(32,fiscal.getCodigoActividadEconomica());
            pst.setString(33,fiscal.getTipoCatContribuyente()); 
            pst.setString(34,fiscal.getGiro()); 
            pst.setInt(35,fiscal.getCodicionPago()); 
            pst.setString(36,fiscal.getCCFAnterior()); 
            pst.setString(37,fiscal.getVtaACuentaDe()); 
            pst.setString(38,fiscal.getNotaRemision()); 
            pst.setString(39,fiscal.getNoFecha()); 
            pst.setDouble(40,fiscal.getSaldoCapital());
            pst.setString(41,fiscal.getDescripcion()); 
            pst.setDouble(42,fiscal.getPrecioUnitario());
            pst.setDouble(43,fiscal.getVentasNoSujetas());
            pst.setDouble(44,fiscal.getIvaItem());
            pst.setDouble(45,fiscal.getDelAl());
            pst.setInt(46,fiscal.getExportaciones()); 
            pst.setInt(47,fiscal.getNumDocRel()); 
            pst.setInt(48,fiscal.getCodTributo()); 
            pst.setDouble(49,fiscal.getTributos()); 
            pst.setInt(50,fiscal.getUniMedidaCodigo()); 
            pst.setDouble(51,fiscal.getVentasExentas());
            pst.setString(52,fiscal.getFecha());
            pst.setInt(53,fiscal.getTipoItem()); 
            pst.setInt(54,fiscal.getTipoDteRel()); 
            pst.setInt(55,fiscal.getCodigoRetencionMH()); 
            pst.setInt(56,fiscal.getCantidad()); 
            pst.setInt(57,fiscal.getVentasGravadas()); 
            pst.setDouble(58,fiscal.getIvaRetenido());
            pst.setDouble(59,fiscal.getDescuento());
            pst.setInt(60,fiscal.getDescuentoItem()); 
            pst.setDouble(61,fiscal.getOtroMonNoAfec()); 
            pst.setString(62,fiscal.getMontoLetras()); 
            pst.setDouble(63,fiscal.getSumas());
            pst.setDouble(64,fiscal.getSubTotalVentasExentas());
            pst.setDouble(65,fiscal.getSubTotalVentasNoSujetas());
            pst.setDouble(66,fiscal.getSubTotalVentasGravadas());
            pst.setDouble(67,fiscal.getVentasGravada());
            pst.setDouble(68,fiscal.getIva());
            pst.setDouble(69,fiscal.getRenta());
            pst.setDouble(70,fiscal.getImpuesto());
            pst.setDouble(71,fiscal.getVentasExenta());
            pst.setDouble(72,fiscal.getVentasNoSujeta());
            pst.setDouble(73,fiscal.getCodigoTributo());
            pst.setInt(74,fiscal.getCodigoTributos());
            pst.setString(75,fiscal.getDescripcionTributo()); 
            pst.setDouble(76,fiscal.getValorTributo());
            pst.setDouble(77,fiscal.getDescuentos());
            pst.setDouble(78,fiscal.getAbonos());
            pst.setInt(79,fiscal.getCantidadTotal());
            pst.setDouble(80,fiscal.getVentaTotal());
            pst.setDouble(81,fiscal.getVentasGravadas13());
            pst.setDouble(82,fiscal.getVentasGravadas0());
            pst.setDouble(83,fiscal.getVentasNoGravadas());
            pst.setDouble(84,fiscal.getIvaPercibido1());
            pst.setDouble(85,fiscal.getIvaPercibido2());
            pst.setDouble(86,fiscal.getIvaRetenido1());
            pst.setDouble(87,fiscal.getIvaRetenido13());
            pst.setDouble(88,fiscal.getMontGDescVentNoSujetas());
            pst.setDouble(89,fiscal.getMontGDescVentExentas());
            pst.setDouble(90,fiscal.getMontGDescVentGrav());
            pst.setDouble(91,fiscal.getTotOtroMonNoAfec());
            pst.setDouble(92,fiscal.getTotalAPagar());
            pst.setDouble(93,fiscal.getSeguro());
            pst.setDouble(94,fiscal.getFlete());
            pst.setDouble(95,fiscal.getContribucionSeguridad());
            pst.setDouble(96,fiscal.getFovial());
            pst.setDouble(97,fiscal.getCotrans());
            pst.setDouble(98,fiscal.getContribucionTurismo5());
            pst.setDouble(99,fiscal.getContribucionTurismo7());
            pst.setDouble(100,fiscal.getImpuestoEspecifico());
            pst.setDouble(101,fiscal.getCesc());
            pst.setString(102,fiscal.getFormatodocumento()); 
            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
}
