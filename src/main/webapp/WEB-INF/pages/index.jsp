<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <script
            src="http://code.jquery.com/jquery-3.2.1.js"
            integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>

</body>
</html>
<html>
<body>
<h1>Maven + Spring MVC - Supermarket with Checkout mechanism Web Project Example</h1>

<h3>Message : ${message}</h3>
<h3>Counter : ${counter}</h3>

<div class="col-md-3">
    <ul class="widget-products">
        <c:forEach var="i" begin="1" end="5">
            <li>
                <a href="#">
                    <span class="img">
                      <img src="http://via.placeholder.com/100x100?text=${productDTO}">
                    </span>
                    <span class="product clearfix">
                        <span class="name">
                                ${productDTO}
                        </span>
                        <span class="price">
                            <i class="fa fa-money">$</i> 320,00
                        </span>
                    </span>
                </a>
            </li>
        </c:forEach>

    </ul>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div class="thumbnail">
                <img src="http://tech.firstpost.com/wp-content/uploads/2014/09/Apple_iPhone6_Reuters.jpg"
                     alt="" class="img-responsive">
                <div class="caption">
                    <h4 class="pull-right">$700.99</h4>
                    <h4><a href="#">Mobile Product</a></h4>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                        Lorem Ipsum has been the industry's standard dummy text ever since the
                        1500s, when an unknown printer took a galley of type and scrambled it to
                        make a type specimen book.</p>
                </div>
                <div class="ratings">
                    <p>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        (15 reviews)
                    </p>
                </div>
                <div class="space-ten"></div>
                <div class="btn-ground text-center">
                    <button type="button" class="btn btn-primary"><i
                            class="fa fa-shopping-cart"></i> Add To Cart
                    </button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#product_view"><i class="fa fa-search"></i> Quick View
                    </button>
                </div>
                <div class="space-ten"></div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="thumbnail">
                <img src="http://tech.firstpost.com/wp-content/uploads/2014/09/Apple_iPhone6_Reuters.jpg"
                     alt="" class="img-responsive">
                <div class="caption">
                    <h4 class="pull-right">$700.99</h4>
                    <h4><a href="#">Mobile Product</a></h4>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                        Lorem Ipsum has been the industry's standard dummy text ever since the
                        1500s, when an unknown printer took a galley of type and scrambled it to
                        make a type specimen book.</p>
                </div>
                <div class="ratings">
                    <p>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        (15 reviews)
                    </p>
                </div>
                <div class="space-ten"></div>
                <div class="btn-ground text-center">
                    <button type="button" class="btn btn-primary"><i
                            class="fa fa-shopping-cart"></i> Add To Cart
                    </button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#product_view"><i class="fa fa-search"></i> Quick View
                    </button>
                </div>
                <div class="space-ten"></div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="thumbnail">
                <img src="http://tech.firstpost.com/wp-content/uploads/2014/09/Apple_iPhone6_Reuters.jpg"
                     alt="" class="img-responsive">
                <div class="caption">
                    <h4 class="pull-right">$700.99</h4>
                    <h4><a href="#">Mobile Product</a></h4>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                        Lorem Ipsum has been the industry's standard dummy text ever since the
                        1500s, when an unknown printer took a galley of type and scrambled it to
                        make a type specimen book.</p>
                </div>
                <div class="ratings">
                    <p>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        (15 reviews)
                    </p>
                </div>
                <div class="space-ten"></div>
                <div class="btn-ground text-center">
                    <button type="button" class="btn btn-primary"><i
                            class="fa fa-shopping-cart"></i> Add To Cart
                    </button>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#product_view"><i class="fa fa-search"></i> Quick View
                    </button>
                </div>
                <div class="space-ten"></div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade product_view" id="product_view">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <a href="#" data-dismiss="modal" class="class pull-right"><span
                        class="glyphicon glyphicon-remove"></span></a>
                <h3 class="modal-title">HTML5 is a markup language</h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-6 product_img">
                        <img src="http://img.bbystatic.com/BestBuy_US/images/products/5613/5613060_sd.jpg"
                             class="img-responsive">
                    </div>
                    <div class="col-md-6 product_content">
                        <h4>Product Id: <span>51526</span></h4>
                        <div class="rating">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            (10 reviews)
                        </div>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting
                            industry. Lorem Ipsum has been the industry's standard dummy text ever
                            since the 1500s, when an unknown printer took a galley of type and
                            scrambled it to make a type specimen book.Lorem Ipsum is simply dummy
                            text of the printing and typesetting industry.</p>
                        <h3 class="cost"><span class="glyphicon glyphicon-usd"></span> 75.00
                            <small class="pre-cost"><span class="glyphicon glyphicon-usd"></span>
                                60.00
                            </small>
                        </h3>
                        <div class="row">
                            <div class="col-md-4 col-sm-6 col-xs-12">
                                <select class="form-control" name="select">
                                    <option value="" selected="">Color</option>
                                    <option value="black">Black</option>
                                    <option value="white">White</option>
                                    <option value="gold">Gold</option>
                                    <option value="rose gold">Rose Gold</option>
                                </select>
                            </div>
                            <!-- end col -->
                            <div class="col-md-4 col-sm-6 col-xs-12">
                                <select class="form-control" name="select">
                                    <option value="">Capacity</option>
                                    <option value="">16GB</option>
                                    <option value="">32GB</option>
                                    <option value="">64GB</option>
                                    <option value="">128GB</option>
                                </select>
                            </div>
                            <!-- end col -->
                            <div class="col-md-4 col-sm-12">
                                <select class="form-control" name="select">
                                    <option value="" selected="">QTY</option>
                                    <option value="">1</option>
                                    <option value="">2</option>
                                    <option value="">3</option>
                                </select>
                            </div>
                            <!-- end col -->
                        </div>
                        <div class="space-ten"></div>
                        <div class="btn-ground">
                            <button type="button" class="btn btn-primary"><span
                                    class="glyphicon glyphicon-shopping-cart"></span> Add To Cart
                            </button>
                            <button type="button" class="btn btn-primary"><span
                                    class="glyphicon glyphicon-heart"></span> Add To Wishlist
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
