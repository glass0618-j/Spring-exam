<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>
<main>
	<div class="container-fluid">
		<h1 class="mt-4">Notice</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
			<li class="breadcrumb-item active">Tables</li>
		</ol>
		<div class="card mb-4">
			<div class="card-body">
				공지사항입니다.
			</div>
		</div>
		<div class="card mb-4">
			<div class="card-header">
				<i class="far fa-bell"></i> notice <a
					class="btn btn-outline-info btn-sm" href="/notice/register"
					style="float: right;">Regist</a>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Nno</th>
								<th>Title</th>
								<th>Writer</th>
								<th>RegDate</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Nno</th>
								<th>Title</th>
								<th>Writer</th>
								<th>RegDate</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${list }" var="notice">
								<tr>
									<td><c:out value="${notice.nno }"></c:out></td>
									<td><a href="/notice/get?nno=${notice.nno }"><c:out
												value="${notice.title }"></c:out></a></td>
									<td><c:out value="${notice.writer }"></c:out></td>
									<td><fmt:formatDate value="${notice.regdate }"
											pattern="yy/MM/dd" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</main>
<div class="modal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Alert</h5>
				<button type="button" class="btn-close" data-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result}"></c:out>';

		showModal(result);

		function showModal(result) {
			if (result === 'success') {
				$('.modal-body').html("Success Remove!")
				$('.modal').modal("show");
				history.pushState(null, null, location.href);
				window.onpopstate = function() {
					$('.modal-body').html("This content has been removed.")
					$('.modal').modal("show");
					history.go(1);
					history.replace(null, null, null);
				};
			}
		}
	});
</script>
<%@ include file="../includes/footer.jsp"%>