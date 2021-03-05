<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container-fluid">
	<div class="card mb-4">
		<c:forEach items="#{comment }" var="list">
			<div class="card-body">
				<div class="input-group">
					<input type="text" class="input-group-text"
						id="comment_writer_${list.id }"
						value='<c:out value="${list.writer }"></c:out>'
						readonly="readonly">
					<textarea class="form-control" readonly="readonly"
						id="comment_content_${list.id }"><c:out
							value="${list.content }"></c:out> </textarea>
					<button type="button" class="btn btn-primary"
						onclick="comment_modify(${list.id })"
						id="comment_modify_${list.id }">Modify</button>
					<button type="button" class="btn btn-danger" onclick="comment_remove(${list.id })">Remove</button>
					<input type="hidden" value="${list.bno }"
						id="comment_bno_${list.id}">
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<div class="modal" tabindex="-1" id="comment_modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Alert</h5>
				<button type="button" class="btn-close" data-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body" id="comment_modal_body">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					id="comment_remove2">Remove</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
function comment_modify(id) {
		console.log("...............................");
		$("#comment_writer_"+id).removeAttr("readonly").attr(
				"required", "required");
		$("#comment_content_"+id).removeAttr("readonly").attr(
				"required", "required");
		$("#comment_modify_"+id).removeAttr("onclick");
		
	$("#comment_modify_"+id).on("click", function(e){
			e.preventDefault();
		
		var comment = new Object();
		comment.id = id;
		comment.content = $("#comment_content_"+id).val();
		comment.writer = $("#comment_writer_"+id).val();
		
		if(comment.content === "" || comment.writer===""){
			alert("댓글을 입력하세요.");
			return;
		}
		
		var bno = $("#comment_bno_"+id).val();
		
		$.ajax({
			data : JSON.stringify(comment),
			contentType : "application/json; charset=utf-8",
			type : "POST",
			url : "/board/comment/comment_modify",
			success : function(){
				comment_list(bno);
			},
			error : function(req, text){
				alert(text+" : "+req.status);
			}
		});
	});	
}
	function comment_list(bno){
		$.ajax({
			type : "GET",
			url : "/board/comment/comment_get_list?bno="+bno,
			success : function(result){
				$("#comment_list").html(result);
			},
			error : function(req, text){
				alert(text+" : "+req.status);
			}
		});
	}
		
	function comment_remove(id){
		$('#comment_modal_body').html("Are you sure you want remove?")
		$('#comment_modal').modal("show");
		
		$('#comment_remove2').click(function(e) {
			var comment = new Object();
			comment.id = id;
			var bno = $("#comment_bno_"+id).val();
			
			$.ajax({
				data : JSON.stringify(comment),
				contentType : "application/json; charset=utf-8",
				type : "POST",
				url : "/board/comment/comment_remove",
				success : function(){
					comment_list(bno);
				},
				error : function(req, text){
					alert(text+" : "+req.status);
				}
			});
		});
	}	
</script>