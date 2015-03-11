$(function () {
    var inputTodo = $("#new-todo");
    inputTodo.keydown(function (evnet) {
        if(evnet.keyCode == 13 && inputTodo.val().length){
            var title = inputTodo.val();
            $.ajax({
                    url: "/add",
                    data: {title: title},
                    type: "POST",
                    success: function (jsonData) {
                        var todo = JSON.parse(jsonData);
                        var targetList = $("#todo-list");
                        targetList.append(makeTodoList(todo.id, todo.title));
                        inputTodo.val("");
                    }
                }
            );
        }
    });


    $(".destroy").live("click", function () {
        console.log("fdsf");
        var id = $(this).closest("li").data("id");
        console.log(id);
    });


    function makeTodoList(id, title) {
        return "<li class='active' data-id=" + id + ">" +
            "<div class='view'>" +
            "<input class='toggle' type='checkbox' />" +
            "<label>" + title + "</label>" +
            "<button class='destroy'></button>" +
            "</div>" +
            "<input class='edit' value='" + title + "'/>" +
            "</li>";
    }


});