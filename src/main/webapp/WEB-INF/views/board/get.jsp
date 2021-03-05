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
				<i class="fas fa-clipboard-list"></i></i> Detail
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<div class="form-group col-md-12">
						<div class="mb-3">
							<label for="title" class="form-label">Title</label> <input
								type="text" class="form-control" id="title" name="title"
								value='<c:out value="${board.title }"></c:out>'
								readonly="readonly">
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
								id="content" name="content" rows="3" readonly="readonly"><c:out
									value="${board.content }"></c:out></textarea>
						</div>
					</div>
					<form id="actionForm">
						<input type="hidden" id="bno" name="bno" value="${board.bno }">
						<input type="hidden" name="pageNum" value="${cri.pageNum }">
						<input type="hidden" name="amount" value="${cri.amount }">
						<input type="hidden" name="type" value="${cri.type }"> <input
							type="hidden" name="keyword" value="${cri.keyword }">

						<button id="btn1" class="btn btn-outline-danger btn-sm"
							style="float: right;">Remove</button>
						<button id="listBtn" class="btn btn-outline-primary btn-sm"
							style="float: right;">Back List</button>
						<button id="modifyBtn" class="btn btn-outline-success btn-sm"
							style="float: right;">Modify</button>
					</form>
				</div>
				<p></p>
				<div class="input-group">
					<input type="text" class="input-group-text" placeholder="Enter Writer" id="comment_writer">
					<textarea class="form-control" placeholder="Enter Comment" id="comment_content"></textarea>
					<button type="button" class="btn btn-primary" id="comment_register">Submit</button>
				</div>
			</div>
		</div>
	</div>
	<div id="comment_list"></div>
</main>
<div class="modal" tabindex="-1" id="board_modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Alert</h5>
				<button type="button" class="btn-close" data-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body" id="board_modal_body">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					id="btn2">Remove</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {

		var actionForm = $("#actionForm");

		$('#btn1').click(function(e) {
			e.preventDefault();
			$('#board_modal_body').html("Are you sure you want remove?")
			$('#board_modal').modal("show");
		});

		$('#btn2').click(function(e) {
			actionForm.attr("action", "/board/remove").attr("method", "post");
			actionForm.submit();
		});

		$("#listBtn").on("click", function(e) {
			e.preventDefault();
			actionForm.find("input[name=bno]").remove();
			actionForm.attr("action", "/board/list")
			actionForm.attr("method", "get");
			actionForm.submit();
		});

		$("#modifyBtn").on("click", function(e) {
			e.preventDefault();
			actionForm.attr("action", "/board/modify")
			actionForm.attr("method", "get");
			actionForm.submit();
		});
		
		comment_list();
		
		function comment_list(){
			$.ajax({
				type : "GET",
				url : "/board/comment/comment_get_list?bno=${board.bno}",
				success : function(result){
					$("#comment_list").html(result);
				},
				error : function(req, text){
					alert(text+" : "+req.status);
				}
			});
		}
		
		$("#comment_register").on("click", function(e){
				e.preventDefault();
			
			var comment = new Object();
			comment.content = $("#comment_content").val();
			comment.writer = $("#comment_writer").val();
			
			if(comment.content === "" || comment.writer===""){
				alert("댓글을 입력하세요.");
				return;
			}
			
			comment.bno = "<c:out value='${board.bno}'></c:out>";
			
			$.ajax({
				data : JSON.stringify(comment),
				contentType : "application/json; charset=utf-8",
				type : "POST",
				url : "/board/comment/comment_register",
				success : function(){
					comment.content = $("#comment_content").val("");
					comment.writer = $("#comment_writer").val("");
					comment_list();
				},
				error : function(req, text){
					alert(text+" : "+req.status);
				}
			});
		});	
	});
</script>
<%@ include file="../includes/footer.jsp"%>
