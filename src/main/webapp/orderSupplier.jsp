<!DOCTYPE html>
<html lang="es">
    <head>

        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headPage.jsp" />
        <title>Heavy | Pedidos Provedor</title>
        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/headTable.jsp" />


    </head>
    <body class="scroll sidebar-toggled">


        <!-- Page Wrapper -->
        <div id="wrapper">
            <!-- NAV -->

            <jsp:include page="/WEB-INF/pagesInfo/indexUtils/nav.jsp" />

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column menu-collapsed">

                <div id="content">

                    <!-- barra top -->
                    <jsp:include page="/WEB-INF/pagesInfo/indexUtils/topbar.jsp" />


                    <!-- contenido-->
                    <div class="container-fluid">
                        <!-- Cards de pedido proveedores -->
                        <jsp:include page="/WEB-INF/pagesInfo/supplierUtils/orderSupplierUtils/cardsOrderSuppliers.jsp" />
                        <!-- tabla  de pedido proveedores-->
                        <jsp:include  page="/WEB-INF/pagesInfo/supplierUtils/orderSupplierUtils/tableOrderSupplier.jsp"/>


                    </div>





                </div>



                <!-- pie de pagina-->
                <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/footerPage.jsp"/>

            </div>


        </div>


        <jsp:include page="/WEB-INF/pagesInfo/indexUtils/scriptsJS.jsp" />
        <jsp:include  page="/WEB-INF/pagesInfo/indexUtils/scriptsTable.jsp"/>
    </body>
</html>