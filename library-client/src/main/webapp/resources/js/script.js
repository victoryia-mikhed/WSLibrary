$(function () {
    $("#delete-submit").click(function () {
        if (confirm("Do you want to delete news?")) {
            $('#form-delete-news').submit();
        }
    });
});