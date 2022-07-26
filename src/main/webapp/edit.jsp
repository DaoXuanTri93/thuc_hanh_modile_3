<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Form Elements | Zircos - Responsive Bootstrap 4 Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Responsive bootstrap 4 admin template" name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- App favicon -->
    <link rel="shortcut icon" href="assets\images\favicon.ico">
    <link href="assets\libs\toastr\toastr.min.css" rel="stylesheet" type="text/css">
    <!-- App css -->
    <link href="assets\css\bootstrap.min.css" rel="stylesheet" type="text/css" id="bootstrap-stylesheet">
    <link href="assets\css\icons.min.css" rel="stylesheet" type="text/css">
    <link href="assets\css\app.min.css" rel="stylesheet" type="text/css" id="app-stylesheet">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


</head>

<body data-layout="horizontal">

<!-- Begin page -->
<div id="wrapper">

    <!-- Navigation Bar-->
    <%@include file="header.jsp" %>
    <jsp:include page="header.jsp"></jsp:include>
    <!-- End Navigation Bar-->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">
            <!-- Start Content-->
            <!-- start page title -->
            <div class="row">
                <div class="col-12">
                    <div class="page-title-box">
                        <h4 class="page-title">Edit</h4>
                        <a href="/product" class="btn btn-success">List Product</a>
                    </div>
                </div>
            </div>
            <!-- end page title -->

            <div class="row">
                <div class="col-sm-12">
                    <div class="card-box">
                        <div class="row">
                            <div class="col-md-12">
                                <form class="form-horizontal" action="/product?action=edit" method="post">
                                    <c:if test="${requestScope['editProduct'] != null}">
                                        <input type="hidden" name="idProduct"
                                               value="<c:out value="${requestScope['editProduct'].getIdProduct()}" />">
                                    </c:if>
                                    <div class="form-group row">
                                        <label class="col-md-2 control-label">Tên Sản Phẩm</label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" name="tenSanPham"
                                                   value="${editProduct.getTenSanPham()}">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-md-2 control-label" for="example-password">Giá</label>
                                        <div class="col-md-10">
                                            <input type="number" id="example-password" name="gia"
                                                   value="${editProduct.getGia()}"
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-md-2 control-label">Số Lượng</label>
                                        <div class="col-md-10">
                                            <input type="number" class="form-control" name="soLuong"
                                                   value="${editProduct.getSoLuong()}">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-md-2 control-label">Màu Sắc</label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" name="mauSac"
                                                   value="${editProduct.getMauSac()}">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-md-2 control-label">Mô Tả</label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" name="moTa"
                                                   value="${editProduct.getMoTa()}">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-md-2 control-label">Danh Mục</label>

                                        <div class="col-md-10">
                                            <select name="danhMuc">
                                                <c:forEach items="${applicationScope.listCategory}" var="listC">
                                                    <c:if test="${listC.getIdCategory() == list.getDanhMuc()}">
                                                        <c:out value="${listC.getDanhMuc()}"/>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <input type="submit" class="btn btn-primary form-control" value="EDIT">
                                    </div>
                                </form>
                            </div>
                            <div>
                                ${errors}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end row -->
        </div>
        <!-- end content -->

        <c:if test="${requestScope.message != null}">

            <script>
                let strMessage = '${requestScope.message}';

                window.onload = function (e) {
                    toastr.options = {
                        "closeButton": true,
                        "debug": false,
                        "newestOnTop": false,
                        "progressBar": false,
                        "positionClass": "toast-top-right",
                        "preventDuplicates": false,
                        "onclick": null,
                        "showDuration": "300",
                        "hideDuration": "1000",
                        "timeOut": "5000",
                        "extendedTimeOut": "1000",
                        "showEasing": "swing",
                        "hideEasing": "linear",
                        "showMethod": "fadeIn",
                        "hideMethod": "fadeOut"
                    }
                    toastr["success"](strMessage)
                }
            </script>
        </c:if>


        <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- end Footer -->

    </div>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->

</div>
<!-- END wrapper -->

<!-- Right Sidebar -->

<!-- Vendor js -->
<jsp:include page="vendor.jsp"></jsp:include>

</body>

</html>