<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jan Koszela
  Date: 10.08.2017
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<!-- Start of cart.jspf -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>
        <span class="glyphicon glyphicon-shopping-cart" style="color: darkkhaki"></span> &nbsp;
        <ins>Shopping Cart</ins>
    </h2>
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Product</th>
                    <th class="text-center">Special price</th>
                    <th>Quantity</th>
                    <th class="text-center">Price</th>
                    <th class="text-center">Total</th>
                    <th> </th>
                </tr>
                </thead>
                <tbody>
                <form action="/${servletPath}/${products}" method="get">
                <%--PRODUCTS--%>
                <c:forEach var="order" items="${cartItem.orders}">

                    </br>
                    <tr>
                        <td class="col-sm-8 col-md-6">
                            <div class="media">
                                <a class="thumbnail pull-left" href="#" data-toggle="modal"
                                   data-target="#product_view_${order.product.id}">
                                    <img class="media-object"
                                         src="http://via.placeholder.com/72x72?text=${order.product.name}"
                                         style="width: 72px; height: 72px;">
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading">
                                        <a href="#" data-toggle="modal"
                                           data-target="#product_view_${order.product.id}">
                                                ${order.product.name}
                                        </a>
                                    </h4>
                                </div>
                            </div>
                        </td>
                        <td class="col-sm-1 col-md-1 text-center">
                            <strong>
                                <c:if test="${order.specialOffer}">
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:if>
                            </strong>
                        </td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                            <input type="hidden" name="product" value="${order.product.name}" >
                            <input type="number" class="form-control"
                                   name="quantity" value="${order.quantity}">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center">
                            <strong>
                                <span class="glyphicon glyphicon-eur"></span>${order.stockPrice.unit}
                            </strong>
                        </td>
                        <td class="col-sm-1 col-md-1 text-center">
                            <strong>
                                <span class="glyphicon glyphicon-eur"></span>${order.totalPrice.unit}
                            </strong>
                        </td>
                        <td class="col-sm-1 col-md-1">
                            <a
                                <%--type="submit" --%>
                                    href="${pageContext.request.contextPath}/${currentPath}/${removeAction}?product=${order.product.name}&quantity=0"
                                    class="btn btn-danger">
                                    <%--<input type="hidden" name="product" value="${order.product.name}" >--%>
                                    <%--<input type="hidden" name="quantity" value="0" >--%>
                                    <%--<span class="btn btn-xs btn-danger pull-right">--%>

                                <span class="glyphicon glyphicon-remove"></span> Remove
                                    <%--</span>--%>

                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <%--END OF PRODUCTS--%>
                <tr>
                    <td>  </td>
                    <td>  </td>
                    <td>  </td>
                    <td><h3>Total</h3></td>
                    <td class="text-right">
                        <h3><strong>
                            <span class="glyphicon glyphicon-eur"></span>
                            ${cartItem.price.unit}
                        </strong></h3>
                    </td>
                    <td>  </td>
                </tr>
                <tr>
                    <td>  </td>
                    <td>  </td>
                    <td>  </td>
                    <td>
                        <a class="btn btn-default"
                           href="${pageContext.request.contextPath}/${products}">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue
                            Shopping
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-success"
                           href="${pageContext.request.contextPath}/${cart}">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </a>
                    </td>
                </tr>
                    </form>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- End of cart.jspf -->