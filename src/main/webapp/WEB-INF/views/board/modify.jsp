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
					<form id="actionForm" enctype="multipart/form-data">
						<div class="form-group col-md-12">
							<div class="mb-3">
								<label for="title" class="form-label">Title</label> <input
									type="text" class="form-control" id="title" name="title"
									value='<c:out value="${board.title }"></c:out>'
									required="required">
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
								<textarea class="form-control border border-secondary"
									id="content" name="content" rows="3" required="required"><c:out
										value="${board.content }"></c:out></textarea>
							</div>
						</div>
						<div class="form-group col-md-12">
							<div class="mb-3">
								<c:if test="${board.filename != null }">
									<div id="filename"></div>
									<button type="button"
										class="btn btn-outline-primary btn-sm fileDelete"
										id="inputGroupFileAddon04">File Delete</button>

								</c:if>
								<div class="input-group">
									<input type="file" class="form-control" name="file"
										id="inputGroupFile04" aria-describedby="inputGroupFileAddon04"
										aria-label="Upload"> <input type="hidden" id="attach" name="attach"
										value="n">
								</div>
							</div>
						</div>
						<input type="hidden" name="bno" id="bno" value="${board.bno }">
						<input type="hidden" name="pageNum" value="${cri.pageNum }">
						<input type="hidden" name="amount" value="${cri.amount }">
						<input type="hidden" name="type" value="${cri.type }"> <input
							type="hidden" name="keyword" value="${cri.keyword }">
						<button type="button" class="btn btn-outline-primary btn-sm"
							id="submitBtn" style="float: right;">Submit</button>
						<button type="button" class="btn btn-outline-success btn-sm"
							id="listBtn" style="float: right;">Back List</button>
						<button type="button" class="btn btn-outline-success btn-sm"
							id="cancelBtn" style="float: right;">Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>
<script type="text/javascript">
	$(document).ready(function() {

		var actionForm = $("#actionForm");

		$("#listBtn").on("click", function(e) {
			e.preventDefault();
			actionForm.find("input[name=bno]").remove();
			actionForm.find("input[name=title]").remove();
			actionForm.find("input[name=writer]").remove();
			actionForm.find("textarea[name=content]").remove();
			actionForm.attr("action", "/board/list")
			actionForm.attr("method", "get");
			actionForm.submit();
		});

		$("#cancelBtn").on("click", function(e) {
			e.preventDefault();
			actionForm.find("input[name=title]").remove();
			actionForm.find("input[name=writer]").remove();
			actionForm.find("textarea[name=content]").remove();
			actionForm.attr("action", "/board/get")
			actionForm.attr("method", "get");
			actionForm.submit();
		});

		$("#submitBtn").on("click", function(e) {
			e.preventDefault();
			actionForm.attr("action", "/board/modify")
			actionForm.attr("method", "post");
			actionForm.submit();
		});

		filenameShow();

		function filenameShow() {
			if ($("#attach").val() === "y") {
				$("#filename").html("");
			} else {
				$("#filename").html("${board.filename}");
			}
		}

		$(".fileDelete").on("click", function(e) {
			e.preventDefault();
			if ($("#attach").val() === "y") {
				$("#attach").val("n");
			} else {
				$("#attach").val("y");
			}
			filenameShow();
		});
	});
</script>
<%@ include file="../includes/footer.jsp"%>
