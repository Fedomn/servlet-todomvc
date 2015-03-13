$(function () {
    var ENTER_KEY = 13;
    var ESCAPE_KEY = 27;

    var util = {
        makeTodoList: function(id, title) {
            return "<li class='active' data-id=" + id + ">" +
                "<div class='view'>" +
                "<input class='toggle' type='checkbox' />" +
                "<label>" + title + "</label>" +
                "<button class='destroy'></button>" +
                "</div>" +
                "<input class='edit' value='" + title + "'/>" +
                "</li>";
        },
        getCheckState: function ($check_box) {
            return !!$check_box.prop("checked");
        },
        getAllCount: function () {
            $.post("/query", {}, function () {


                });
        }
    };

    var App = {
        init: function () {
            this.allTodoCount = $.cookie("allTodoCount");
            this.activeTodoCount = $.cookie("activeTodoCount");
            //console.log(this.allTodoCount, this.activeTodoCount);
            this.cacheElements();
            this.bindEvents();
        },

        cacheElements: function () {
            this.$todoApp = $('#todoapp');
            this.$header = this.$todoApp.find('#header');
            this.$main = this.$todoApp.find('#main');
            this.$footer = this.$todoApp.find('#footer');
            this.$newTodo = this.$header.find('#new-todo');
            this.$toggleAll = this.$main.find('#toggle-all');
            this.$todoList = this.$main.find('#todo-list');
            this.$count = this.$footer.find('#todo-count');
            this.$clearBtn = this.$footer.find('#clear-completed');
        },

        bindEvents: function () {
            var list = this.$todoList;
            //add
            this.$newTodo.on('keyup', this.add.bind(this));
            //delete
            list.on('click', '.destroy', this.destroy.bind(this));
            //update
            list.on('dblclick', 'label', this.edit.bind(this));
            list.on('keyup', '.edit', this.editKeyup.bind(this));
            list.on('focusout', '.edit', this.update.bind(this));
            //toggle
            list.on('change', '.toggle', this.toggle.bind(this));
            //toggleAll
            this.$toggleAll.on('change', this.toggleAll.bind(this));
            //this.$footer.on('click', '#clear-completed', this.destroyCompleted.bind(this));
        },

        add: function (e) {
            var $input = $(e.target);
            var title = $input.val().trim();

            if (e.which !== ENTER_KEY || !title ) {
                return;
            }
            $.ajax({
                url: "/add",
                data: {title: title},
                type: "POST",
                success: function (jsonData) {
                    var todo = JSON.parse(jsonData);
                    $("#todo-list").append(util.makeTodoList(todo.id, todo.title));
                    $input.val("");
                    App.activeTodoCount++;
                    App.allTodoCount++;
                    //console.log(App.activeTodoCount);
                }
            });
        },

        destroy: function (e) {
            var $li = $(e.target).closest("li");
            var id = $li.data("id");
            console.log(id);
            $.ajax({
                url: "/delete",
                data: {id: id},
                type: "POST",
                success: function () {
                    $li.remove();
                }
            });
        },

        edit: function (e) {
            var $input = $(e.target).closest("li").addClass("editing").find(".edit");
            $input.val($input.val()).focus();
        },

        editKeyup: function (e) {
            if (e.which === ENTER_KEY) {
                e.target.blur();
            }

            if (e.which === ESCAPE_KEY) {
                $(e.target).data('abort', true).blur();
            }
        },

        update: function (e) {
            var el = e.target;
            var $el = $(el);
            var $li = $(e.target).closest("li");
            var $label = $li.find("label");

            var id = $(e.target).closest("li").data("id");
            var title = $el.val().trim();
            var $check_box = $li.find(".toggle");

            if ($el.data('abort')) {
                $el.data('abort', false);
                $li.removeClass("editing");
                $li.find(".edit").val('');
                return;
            }

            $.ajax({
                url: "/update",
                data: {id: id, title: title, complete: util.getCheckState($check_box)},
                type: "POST",
                success: function () {
                    $label.text(title);
                    $li.removeClass("editing");
                }
            });
        },

        toggle: function (e) {
            var $check_bok = $(e.target);
            var $li = $check_bok.closest("li");
            var id = $li.data("id");
            var title = $li.find(".edit").val();
            $.ajax({
                url: "/update",
                data: {id: id, title: title, complete: util.getCheckState($check_bok)},
                type: "POST",
                success: function () {
                    $check_bok.closest("li").toggleClass("completed");
                }
            });
        },

        toggleAll: function (e) {
            var isChecked = $(e.target).prop('checked');
            //.....
        }



    };

    App.init();

});