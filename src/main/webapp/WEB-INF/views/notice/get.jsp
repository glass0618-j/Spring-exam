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
				<i class="fas fa-table mr-1"></i> Detail
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<div class="form-group col-md-12">
						<div class="mb-3">
							<label for="title" class="form-label">Title</label> <input
								type="text" class="form-control" id="title" name="title"
								value='<c:out value="${notice.title }"></c:out>'
								readonly="readonly">
						</div>
					</div>
					<div class="form-group col-md-12">
						<div class="mb-3 row">
							<label for="writer" class="col-sm-2 col-form-label">Writer</label>
							<div class="col-sm-10">
								<input type="text" readonly="readonly"
									class="form-control-plaintext" id="writer" name="writer"
									value='<c:out value="${notice.writer }"></c:out>'>
							</div>
						</div>
					</div>
					<div class="form-group col-md-12">
						<div class="mb-3">
							<label for="exampleFormControlTextarea1" class="form-label">Content</label>
							<textarea class="form-control border border-secondary"
								id="content" name="content" rows="3" readonly="readonly"><c:out
									value="${notice.content }"></c:out></textarea>
						</div>
					</div>
					<form action="/notice/remove" method="post">
						<input type="hidden" id="nno" name="nno" value="${notice.nno }">
						<input type="button" value="remove" id="btn1"
							class="btn btn-outline-danger btn-sm" style="float: right;"> <a
							href="/notice/list" class="btn btn-outline-primary btn-sm"
							style="float: right;">List</a> <a
							href="/notice/modify?nno=${notice.nno }"
							class="btn btn-outline-success btn-sm" style="float: right;">Modify</a>
					</form>
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
				<button type="button" class="btn btn-primary"
					data-dismiss="modal" id="btn2">Remove</button>
				<button type="button" class="btn btn-secondary"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#btn1').click(function(e){
			e.preventDefault();
			$('.modal-body').html("Are you sure you want remove?")
			$('.modal').modal("show");
		});
		
		$('#btn2').click(function(e){
			$('form').submit();
		});
		
	});
</script>
<%@ include file="../includes/footer.jsp"%>
