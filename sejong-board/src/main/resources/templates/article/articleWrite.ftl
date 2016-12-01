<#include "/_layout/base.ftl">
<#macro pageStyle>
<link href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-tokenfield/0.12.0/css/bootstrap-tokenfield.min.css"
      rel="stylesheet">
<link href="//cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">

</#macro>
<#macro pageContents>
<div class="header-wrapper row">
    <div class="col-sm-offset-2 col-sm-10">
        <h1>게시물 작성</h1>
        <hr>
    </div>
</div>

<div class="article-wrapper row">
    <form class="form-horizontal" id="articleForm" method="post" action="/articles">
        <div class="form-group">
            <label for="author" class="col-sm-2 control-label">지은이</label>
            <div class="col-sm-4">
                <input type="text" name="author" class="form-control input-sm" id="author">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">비밀번호</label>
            <div class="col-sm-4">
                <input type="password" name="password" class="form-control input-sm" id="password">
            </div>
        </div>
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">제목</label>
            <div class="col-sm-10">
                <input type="text" name="title" class="form-control input-sm" id="title">
            </div>
        </div>

        <div class="form-group">
            <label for="tags" class="col-sm-2 control-label">태그</label>
            <div class="col-sm-10">
                <input type="text" name="tags" class="tokenfield form-control input-sm" id="tags" data-role="tagsinput">
            </div>
        </div>

        <div class="form-group">
            <label for="contents" class="col-sm-2 control-label">본문</label>
            <div class="col-sm-10">
                <div id="summernote"></div>
                <input type="hidden" id="contents" name="contents" value="">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <span>
                    <a href="/articles" class="btn btn-default btn-lg">목록</a>
                </span>
                <span class="pull-right">
                    <button type="submit" class="btn btn-default btn-lg">저장</button>
                </span>
            </div>
        </div>
    </form>
</div>
</#macro>

<#macro pageScript>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-tokenfield/0.12.0/bootstrap-tokenfield.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
<script>
    $(".tokenfield").tokenfield();

    $('#summernote').summernote({
        height: 300,
        lang: 'ko-KR',
        toolbar: [
            ['style', ['style', 'bold', 'italic', 'underline', 'clear']],
            ['font', ['fontname','fontsize','color']],
            ['para', ['ul', 'ol', 'paragraph']]
        ]
    });

    $("#articleForm").submit(function(e){
        e.preventDefault();

        var contents = $('#summernote').summernote('code');
        $("#contents").val(contents);

        this.submit();
    });

</script>
</#macro>

<@pageLayout/>