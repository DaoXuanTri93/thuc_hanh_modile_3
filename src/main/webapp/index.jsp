<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>List Customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Responsive bootstrap 4 admin template" name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- App favicon -->
    <%--    <link href="assets\libs\sweetalert2\sweetalert2.min.css" rel="stylesheet" type="text/css">--%>
    <link rel="shortcut icon" href="assets\images\favicon.ico">
    <link href="assets/js/sweetalert2.min.css" rel="stylesheet" type="text/css">
    <link href="assets\css\bootstrap.min.css" rel="stylesheet" type="text/css" id="bootstrap-stylesheet">
    <link href="assets\css\icons.min.css" rel="stylesheet" type="text/css">
    <link href="assets\css\app.min.css" rel="stylesheet" type="text/css" id="app-stylesheet">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body data-layout="horizontal">

<!-- Begin page -->
<div id="wrapper">
    <jsp:include page="/header.jsp"></jsp:include>
    <!-- Navigation Bar-->
    <!-- End Navigation Bar-->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">
            <!-- Start Content-->
            <div class="col-md-12">
                <div class="card-box">
                    <div class="table-responsive">
                        <h4 class="header-title mb-4"><a href="/customer">List Customers</a></h4>
                        <form action="search" method="post">
                            <div class="input-group col-md-4" style="
                                                margin-left: auto;
                                                 margin-bottom: 10px;">
                                <input type="text" class="form-control rounded" placeholder="Search..."
                                       aria-label="Search"
                                       aria-describedby="search-addon" name="search" id="myInput"/>
                                <input type="submit" class="btn btn-primary" value="search">
                            </div>
                        </form>
                        <script>
                            $(document).ready(function () {
                                $("#myInput").on("keyup", function () {
                                    var value = $(this).val().toLowerCase();
                                    $("#myTable tr").filter(function () {
                                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                    });
                                });
                            });
                        </script>
                        <table class="table table-hover table-centered m-0 text-center">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Color</th>
                                <th>Descript</th>
                                <th>Danh Muc</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody id="myTable">

                            <c:forEach items="${listP}" var="list">
                                <tr>
                                    <td>${list.getIdProduct()}</td>
                                    <td>${list.getTenSanPham()}</td>
                                    <td>${list.getGia()}</td>
                                    <td>${list.getSoLuong()}</td>
                                    <td>${list.getMauSac()}</td>
                                    <td>${list.getMoTa()}</td>
                                    <td>
                                        <c:forEach items="${applicationScope.listCategory}" var="listC">
                                            <c:if test="${listC.getIdCategory() == list.getDanhMuc()}">
                                                <c:out value="${listC.getDanhMuc()}"/>
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <a href="product?action=create" class="btn btn-outline-success">Add</a>
                                        <a href="product?action=edit&product=${list.getIdProduct()}"
                                           class="btn btn-outline-success">Edit</a>
                                        <a onclick="showMessage(idProduct=${list.getIdProduct()})"
                                           class="btn btn-outline-success">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                        <script>
                            function showMessage(id) {
                                Swal.fire({
                                    title: 'Are you sure?',
                                    text: "You won't be able to revert this!",
                                    icon: 'warning',
                                    showCancelButton: true,
                                    confirmButtonColor: '#3085d6',
                                    cancelButtonColor: '#d33',
                                    confirmButtonText: 'Yes, delete it!'
                                }).then((result) => {
                                    if (result.isConfirmed) {
                                        window.location.href = "/product?action=delete&delete=" + id;
                                    }
                                })
                            }
                        </script>

                        <%--For displaying Next link --%>


                    </div>


                    <!-- table-responsive -->
                </div>
                <!-- end card -->
            </div>
            <!-- end col -->

        </div>
        <!-- end row -->
        <!-- end container-fluid -->

    </div>


    <!-- end content -->
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

<jsp:include page="/vendor.jsp"></jsp:include>

<%--    <jsp:param name="vendor_js" value="index"></jsp:param>--%>

</body>

</html>