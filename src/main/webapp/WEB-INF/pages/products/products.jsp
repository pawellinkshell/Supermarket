<%--
  Created by IntelliJ IDEA.
  User: Jan Koszela
  Date: 10.08.2017
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<!-- Start of products.jspf -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>
        <span class="glyphicon glyphicon-tag" style="color: darkkhaki"></span> &nbsp;
        <ins>Product lists</ins>
    </h2>
    <div class="row">
        <c:forEach var="product" items="${productItems}">
            <div class="col-md-4">
                <div class="thumbnail">
                    <img src="http://via.placeholder.com/300x200?text=${product.key.item}"
                         alt="" class="img-responsive">
                    <div class="caption">
                        <h4 class="pull-right">
                            <span class="glyphicon glyphicon-eur"></span> ${product.value.unit}
                        </h4>
                        <h4>
                            <a href="#">${product.key.item}</a>
                        </h4>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting
                            industry.
                            Lorem Ipsum has been the industry's standard dummy text ever since the
                            1500s, when an unknown printer took a galley of type and scrambled it to
                            make a type specimen book.
                        </p>
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
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#product_view_${product.key.id}"><i class="fa fa-search"></i>
                            Quick View
                        </button>
                    </div>
                    <div class="space-ten"></div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<!-- End of products.jspf -->