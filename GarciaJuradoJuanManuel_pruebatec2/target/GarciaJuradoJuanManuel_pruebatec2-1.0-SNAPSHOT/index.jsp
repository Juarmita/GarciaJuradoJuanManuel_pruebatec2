<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/head.jsp" %>  
    <body id="page-top">
        <!-- Navigation-->
        <%@include file="components/nav.jsp" %>
        <!-- Header-->
        <%@include file="components/header.jsp"%>
        <!--Datos section-->
        <section id="datos">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Introduzca sus datos</h2>
                        <p class="lead">Una vez introducidos de forma correcta podra agregar un turno.</p>
                        <ul>
                            <form action="SvCiudadano" method="POST">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="nombre">Nombre: </label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="apellido">Apellidos: </label>
                                        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido">
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="dni">DNI: </label>
                                    <input type="text" class="form-control" id="dni" name="dni" placeholder="DNI" pattern="[0-9]{8}[A-Za-z]{1}" title="Introduzca un DNI válido"><!--uso regex para el filtrado del Dni-->
                                </div>
                                <button type="submit" class="btn btn-success">Registrar datos</button>
                            </form>
                        </ul>
                        <div class="row gx-4 justify-content-center">
                            <p>Para conocer el numero de id puede listar los ciudadanos dados de alta, pulsando en mostrar ciudadanos</p>
                            <ul>
                                <form action="SvCiudadano" method="Get">
                                    <div class="col-lg-8">
                                        <h2>Ver listado de ciudadanos</h2>
                                        <button type="submit" class="btn btn-success">Mostrar ciudadanos</button>
                                    </div>
                                </form>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Turnos section-->
        <section class="bg-light" id="turnos">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Obtener turno</h2>
                        <p class="lead">Introduzca su id y tramite para obtener su turno </p>
                        <form action="SvTurno" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <div class="form-group row-md-3">
                                        <label for="id">Id: </label>
                                        <input type="text" class="form-control" id="id" name="id" placeholder="Id">
                                    </div>
                                    <div class="form-group row-md-3">
                                        <label for="selecTramite">Trámite</label>
                                        <select id="selecTramite" name="tramite" class="form-control">
                                            <option value="padron">Padrón</option>
                                            <option value="multas">Multas</option>
                                            <option value="tributos">Tributos</option>
                                        </select>
                                    </div>
                                    <div class="form-group row-md-3">
                                        <label for="fecha">Fecha: </label>
                                        <input type="date" class="form-control" id="fecha" name="fecha">
                                    </div>
                                    <div class="form-group row-md-3">
                                        <button type="submit" class="btn btn-success">Enviar</button>
                                    </div>
                                </div>

                            </div>
                        </form>
                        <div class="container">
                            <div class="row gx-4 justify-content-center">
                                <form action="SvTurno" method="GET">
                                    <div class="col-lg-8">
                                        <h2>Ver listado de turnos</h2>
                                        <button type="submit" class="btn btn-success">Mostrar turnos</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>

        </section>
        <!-- Listado section-->
        <section id="contact">

        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container px-4">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>

