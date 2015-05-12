<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@include file="common/header.jsp" %>
<%@include file="common/leftMenu.jsp" %>
<div class="main-content">
  <div class="page-content">
	<div class="page-header">
        <h1>
            Database
            <small>
                <i class="icon-double-angle-right"></i>
                database name
            </small>
        </h1>
    </div><!-- /.page-header -->

    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->

            <h4 class="pink">
                <i class="icon-hand-right icon-animated-hand-pointer blue"></i>
                <a href="#" id="connDs" role="button" class="green" data-toggle="modal" data-target="#connDb"> connect database </a>

            </h4>

            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th class="center">
                                        <label>
                                            <input type="checkbox" class="ace" />
                                            <span class="lbl"></span>
                                        </label>
                                    </th>
                                    <th>tableName</th>
                                    <th>Price</th>
                                    <th class="hidden-480">Clicks</th>

                                    <th>
                                        <i class="icon-time bigger-110 hidden-480"></i>
                                        Update
                                    </th>
                                    <th class="hidden-480">Status</th>

                                    <th></th>
                                </tr>
                            </thead>

                            <tbody>
                               <c:choose>
                                   <c:when test="${empty failMsg}">

                                       <c:forEach var="table" items="${database.tables}">
                                            <tr>
                                                <td class="center">
                                                    <label>
                                                        <input type="checkbox" class="ace" />
                                                        <span class="lbl"></span>
                                                    </label>
                                                </td>

                                                <td>
                                                    <a href="#">${table.tableName}</a>
                                                </td>
                                                <td>$45</td>
                                                <td class="hidden-480">3,330</td>
                                                <td>Feb 12</td>

                                                <td class="hidden-480">
                                                    <span class="label label-sm label-warning">Expiring</span>
                                                </td>

                                                <td>
                                                    <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                                        <button class="btn btn-xs btn-success">
                                                            <i class="icon-ok bigger-120"></i>
                                                        </button>

                                                        <button class="btn btn-xs btn-info">
                                                            <i class="icon-edit bigger-120"></i>
                                                        </button>

                                                        <button class="btn btn-xs btn-danger">
                                                            <i class="icon-trash bigger-120"></i>
                                                        </button>

                                                        <button class="btn btn-xs btn-warning">
                                                            <i class="icon-flag bigger-120"></i>
                                                        </button>
                                                    </div>

                                                    <div class="visible-xs visible-sm hidden-md hidden-lg">
                                                        <div class="inline position-relative">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
                                                                <i class="icon-cog icon-only bigger-110"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
                                                                <li>
                                                                    <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                                                        <span class="blue">
                                                                            <i class="icon-zoom-in bigger-120"></i>
                                                                        </span>
                                                                    </a>
                                                                </li>

                                                                <li>
                                                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                                        <span class="green">
                                                                            <i class="icon-edit bigger-120"></i>
                                                                        </span>
                                                                    </a>
                                                                </li>

                                                                <li>
                                                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                        <span class="red">
                                                                            <i class="icon-trash bigger-120"></i>
                                                                        </span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                       </c:forEach>
                                   </c:when>
                                   <c:otherwise>
                                       <font color='red'>${failMsg}</font>
                                   </c:otherwise>
                               </c:choose>
                            </tbody>
                        </table>
                    </div><!-- /.table-responsive -->
                </div><!-- /span -->
            </div><!-- /row -->

        </div>
    </div>
  </div>
</div><!-- /.main-content -->

<div id="connDb" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" aria-hidden="true">
    <div class="modal-dialog">
            <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">new database connect.</h4>
                  </div>
                  <div class="modal-body">
                    <form class="form-horizontal" id="validation-form" method="post" action="connDb.htm">
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="dbUrl">Db url:</label>

                            <div class="col-xs-12 col-sm-9">
                                <div class="clearfix">
                                    <input type="dbUrl" name="dbUrl" id="dbUrl" class="col-xs-12 col-sm-6" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="username">UserName:</label>

                            <div class="col-xs-12 col-sm-9">
                                <div class="clearfix">
                                    <input type="username" name="username" id="username" class="col-xs-12 col-sm-4" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="password">Password:</label>

                            <div class="col-xs-12 col-sm-9">
                                <div class="clearfix">
                                    <input type="password" name="password" id="password" class="col-xs-12 col-sm-4" />
                                </div>
                            </div>
                        </div>
                    </form>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="connBtn" data-last="Finish ">Connect</button>
                  </div>
                </div>
     </div>

</div>

<%@include file="common/footer.jsp" %>

<script type="text/javascript">

   jQuery(function($) {
        $('#connBtn').on('click',function(){
            $('#validation-form').submit();
        })


        $('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                dbUrl: {
                    required: true
                },
                username: {
                    required: true
                },
                password: {
                    required: true
                }
            },
            messages: {
                dbUrl: {
                    required: "Please provide a url."
                },
                password: {
                    required: "Please provide a password."
                },
                username: {
                    required: "Please provide a username."
                }
            },

            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },

            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
                $(e).remove();
            },

            errorPlacement: function (error, element) {
                if(element.is(':checkbox') || element.is(':radio')) {
                    var controls = element.closest('div[class*="col-"]');
                    if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
                    else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                }
                else if(element.is('.select2')) {
                    error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                }
                else if(element.is('.chosen-select')) {
                    error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                }
                else error.insertAfter(element.parent());
            },

            submitHandler: function (form) {
                form.submit();
            },
            invalidHandler: function (form) {
            }
        });
   });


</script>


