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
					<button type="button" class="btn btn-danger">Remove</button>
				</div>
			</div>
		</c:forEach>
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
		
		$.ajax({
			data : console.log(JSON.stringify(comment)),
			contentType : "application/json; charset=utf-8",
			type : "POST",
			url : "/board/comment/comment_modify",
			success : function(){
				comment_list();
			},
			error : function(req, text){
				alert(text+" : "+req.status);
			}
		});
	});
		
}
	
</script>