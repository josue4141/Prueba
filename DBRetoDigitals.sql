CREATE DATABASE retoDigital;
USE retoDigital;

CREATE TABLE faturaConsumidorFinal(
idfaturaConsumidorFinal INT PRIMARY KEY AUTO_INCREMENT,
nit VARCHAR(50),
nrc VARCHAR(10),
idDepartamentoEmisor INT,
idMunicipioEmisor INT,
direccionEmisor VARCHAR(100),
fechaEnvio DATE,
fechaEmision DATE,
terminal VARCHAR(50),
numFactura INT,
correlativoInterno INT,
numeroTransaccion INT,
codigoUsuario INT, 
nombreUsuario VARCHAR(60),
correoUsuario VARCHAR(50),
cajaSuc VARCHAR(10),
tipoDocumento VARCHAR(5),
pdv VARCHAR(10),
nitCliente VARCHAR(50),
duiCliente VARCHAR(10),
nrcCliente VARCHAR(10),
codigoCliente INT,
nombreCliente VARCHAR(60),
direccionCliente VARCHAR(100),
departamento VARCHAR(30),
municipio VARCHAR(30),
telefono VARCHAR(20),
email VARCHAR(50),
sms VARCHAR(20),
whatsapp VARCHAR(20),
idDepartamentoReceptor INT,
idMunicipioReceptor INT,
codigoActividadEconomica INT,
tipoCatContribuyente VARCHAR(50),
giro VARCHAR(100),
codicionPago INT,
CCFAnterior VARCHAR(50),
vtaACuentaDe VARCHAR(50),
notaRemision VARCHAR(100),
noFecha VARCHAR(10),
saldoCapital DECIMAL(5,2),
descripcion VARCHAR(100),
precioUnitario DECIMAL(5,2),
ventasNoSujetas DECIMAL(5,2),
ivaItem DECIMAL(5,2),
delAl DECIMAL(5,2),
exportaciones INT,
numDocRel INT,
codTributo INT,
tributos INT,
uniMedidaCodigo INT,
ventasExentas DECIMAL(5,2),
fecha VARCHAR(30),
tipoItem INT,
tipoDteRel INT,
codigoRetencionMH  INT,
cantidad  INT,
ventasGravadas  INT,
ivaRetenido DECIMAL(5,2),
descuento DECIMAL(5,2),
descuentoItem INT,
otroMonNoAfec INT,
montoLetras VARCHAR(50),
sumas DECIMAL(5,2),
subTotalVentasExentas DECIMAL(5,2),
subTotalVentasNoSujetas DECIMAL(5,2), 
subTotalVentasGravadas DECIMAL(5,2), 
ventasGravada DECIMAL(5,2), 
iva DECIMAL(5,2), 
renta DECIMAL(5,2), 
impuesto DECIMAL(5,2), 
ventasExenta DECIMAL(5,2), 
ventasNoSujeta DECIMAL(5,2), 
codigoTributo DECIMAL(5,2), 
codigoTributos INT,
descripcionTributo VARCHAR(100),
valorTributo DECIMAL(5,2), 
descuentos DECIMAL(5,2), 
abonos DECIMAL(5,2), 
cantidadTotal INT,
ventaTotal DECIMAL(5,2), 
ventasGravadas13 DECIMAL(5,2), 
ventasGravadas0  DECIMAL(5,2), 
ventasNoGravadas DECIMAL(5,2), 
ivaPercibido1 DECIMAL(5,2), 
ivaPercibido2  DECIMAL(5,2), 
ivaRetenido1 DECIMAL(5,2), 
ivaRetenido13 DECIMAL(5,2), 
montGDescVentNoSujetas DECIMAL(5,2), 
montGDescVentExentas DECIMAL(5,2), 
montGDescVentGrav DECIMAL(5,2), 
totOtroMonNoAfec DECIMAL(5,2), 
totalAPagar DECIMAL(5,2), 
seguro DECIMAL(5,2), 
flete DECIMAL(5,2), 
contribucionSeguridad DECIMAL(5,2), 
fovial DECIMAL(5,2), 
cotrans DECIMAL(5,2), 
contribucionTurismo5 DECIMAL(5,2), 
contribucionTurismo7 DECIMAL(5,2), 
impuestoEspecifico DECIMAL(5,2), 
cesc DECIMAL(5,2), 
formatodocumento VARCHAR(20)
);
CREATE TABLE creditoFiscal(
idCreditoFiscal INT PRIMARY KEY AUTO_INCREMENT,
nit VARCHAR(50),
nrc VARCHAR(10),
idDepartamentoEmisor INT,
idMunicipioEmisor INT,
direccionEmisor VARCHAR(100),
fechaEnvio DATE,
fechaEmision DATE,
terminal VARCHAR(50),
numFactura INT,
correlativoInterno INT,
numeroTransaccion INT,
codigoUsuario INT, 
nombreUsuario VARCHAR(60),
correoUsuario VARCHAR(50),
cajaSuc VARCHAR(10),
tipoDocumento VARCHAR(5),
pdv VARCHAR(10),
nitCliente VARCHAR(50),
duiCliente VARCHAR(10),
nrcCliente VARCHAR(10),
codigoCliente INT,
nombreCliente VARCHAR(60),
direccionCliente VARCHAR(100),
departamento VARCHAR(30),
municipio VARCHAR(30),
telefono VARCHAR(20),
email VARCHAR(50),
sms VARCHAR(20),
whatsapp VARCHAR(20),
idDepartamentoReceptor INT,
idMunicipioReceptor INT,
codigoActividadEconomica INT,
tipoCatContribuyente VARCHAR(50),
giro VARCHAR(100),
codicionPago INT,
CCFAnterior VARCHAR(50),
vtaACuentaDe VARCHAR(50),
notaRemision VARCHAR(100),
noFecha VARCHAR(10),
saldoCapital DECIMAL(5,2),
descripcion VARCHAR(100),
precioUnitario DECIMAL(5,2),
ventasNoSujetas DECIMAL(5,2),
ivaItem DECIMAL(5,2),
delAl DECIMAL(5,2),
exportaciones INT,
numDocRel INT,
codTributo INT,
tributos INT,
uniMedidaCodigo INT,
ventasExentas DECIMAL(5,2),
fecha VARCHAR(30),
tipoItem INT,
tipoDteRel INT,
codigoRetencionMH  INT,
cantidad  INT,
ventasGravadas  INT,
ivaRetenido DECIMAL(5,2),
descuento DECIMAL(5,2),
descuentoItem INT,
otroMonNoAfec INT,
montoLetras VARCHAR(50),
sumas DECIMAL(5,2),
subTotalVentasExentas DECIMAL(5,2),
subTotalVentasNoSujetas DECIMAL(5,2), 
subTotalVentasGravadas DECIMAL(5,2), 
ventasGravada DECIMAL(5,2), 
iva DECIMAL(5,2), 
renta DECIMAL(5,2), 
impuesto DECIMAL(5,2), 
ventasExenta DECIMAL(5,2), 
ventasNoSujeta DECIMAL(5,2), 
codigoTributo DECIMAL(5,2), 
codigoTributos INT,
descripcionTributo VARCHAR(100),
valorTributo DECIMAL(5,2), 
descuentos DECIMAL(5,2), 
abonos DECIMAL(5,2), 
cantidadTotal INT,
ventaTotal DECIMAL(5,2), 
ventasGravadas13 DECIMAL(5,2), 
ventasGravadas0  DECIMAL(5,2), 
ventasNoGravadas DECIMAL(5,2), 
ivaPercibido1 DECIMAL(5,2), 
ivaPercibido2  DECIMAL(5,2), 
ivaRetenido1 DECIMAL(5,2), 
ivaRetenido13 DECIMAL(5,2), 
montGDescVentNoSujetas DECIMAL(5,2), 
montGDescVentExentas DECIMAL(5,2), 
montGDescVentGrav DECIMAL(5,2), 
totOtroMonNoAfec DECIMAL(5,2), 
totalAPagar DECIMAL(5,2), 
seguro DECIMAL(5,2), 
flete DECIMAL(5,2), 
contribucionSeguridad DECIMAL(5,2), 
fovial DECIMAL(5,2), 
cotrans DECIMAL(5,2), 
contribucionTurismo5 DECIMAL(5,2), 
contribucionTurismo7 DECIMAL(5,2), 
impuestoEspecifico DECIMAL(5,2), 
cesc DECIMAL(5,2), 
formatodocumento VARCHAR(20)
);   
SELECT * FROM creditoFiscal;
SELECT * FROM faturaConsumidorFinal