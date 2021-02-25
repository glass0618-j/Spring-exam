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
				DataTables is a third party plugin that is used to generate the demo
				table below. For more information about DataTables, please visit the
				<a target="_blank" href="https://datatables.net/">official
					DataTables documentation</a> .
			</div>
		</div>
		<div class="card mb-4">
			<div class="card-header">
				<i class="far fa-registered"></i> Register
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<form action="/notice/register" method="post">
						<div class="form-group col-md-12">
							<div class="mb-3">
								<label for="title" class="form-label">Title</label> <input
									type="text" class="form-control" id="title" name="title"
									placeholder="Enter Title" required="required">
							</div>
						</div>
						<div class="form-group col-md-12">
							<div class="mb-3 row">
								<label for="writer" class="col-sm-2 col-form-label">Writer</label>
								<div class="col-sm-10">
									<input type="text" class="form-control-plaintext" id="writer"
										name="writer" placeholder="Enter Writer" required="required">
								</div>
							</div>
						</div>
						<div class="form-group col-md-12">
							<div class="mb-3">
								<label for="exampleFormControlTextarea1" class="form-label">Content</label>
								<textarea class="form-control border border-secondary"
									id="content" name="content" rows="3"
									placeholder="Enter Content"></textarea>
							</div>
						</div>
						<input type="submit" value="Submit" class="btn btn-outline-primary btn-sm" style="float: right;">
						<a href="/notice/list" class="btn btn-outline-secondary btn-sm"
							style="float: right;">Back List</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>
<%@ include file="../includes/footer.jsp"%>
