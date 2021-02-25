<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>
<main>
	<div class="container-fluid">
		<h1 class="mt-4">Board</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
			<li class="breadcrumb-item active">Tables</li>
		</ol>
		<div class="card mb-4">
			<div class="card-body">
				DataTables is a third party plugin that is used to generate the demo
				table below. For more information about DataTables, please visit the
				<a target="_blank" href="https://datatables.net/">official
					DataTables documentation</a> .
			</div>
		</div>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-cut"></i> Modify
			</div>
			<div class="card-body">
				<div class="table-responsive">
				<form action="/board/modify" method="post">
				<div class="form-group col-md-12">
					<div class="mb-3">
						<label for="title" class="form-label">Title</label> <input
							type="text" class="form-control" id="title" name="title"
							value='<c:out value="${board.title }"></c:out>' required="required">
					</div>
				</div>
				<div class="form-group col-md-12">
					<div class="mb-3 row">
						<label for="writer" class="col-sm-2 col-form-label">Writer</label>
						<div class="col-sm-10">
							<input type="text" readonly="readonly"
								class="form-control-plaintext" id="writer" name="writer"
								value='<c:out value="${board.writer }"></c:out>'>
						</div>
					</div>
				</div>
				<div class="form-group col-md-12">
					<div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label">Content</label>
						<textarea class="form-control border border-secondary" id="content" name="content"
							rows="3" required="required"><c:out value="${board.content }"></c:out></textarea>
					</div>
				</div>
				<input type="hidden" name="bno" id="bno" value="${board.bno }">
				<input type="submit" class="btn btn-outline-success btn-sm" value="Submit" style="float: right;">
					<a href="/board/list" class="btn btn-outline-primary btn-sm" style="float: right;">List</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>
<%@ include file="../includes/footer.jsp"%>
