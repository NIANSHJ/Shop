$(function () {
    $(".num .sub").click(function () {
        let c = parseInt($(this).siblings("span").text());
        if (c <= 1) {
            $(this).attr("disabled", "disabled")
        } else {
            c--;
            $(this).siblings("span").text(c);

            if ($(this).siblings("span").attr('datasrc')) {
                let url = "/cart_num?count=" + c + "&id=" + $(this).siblings("span").attr('datasrc');
                $.post(url, function () {
                });
            }
            let d = $(this).parents(".number").prev().text().substring(1);
            $(this).parents(".th").find(".sAll").text("￥" + (c * d).toFixed(2));
            a();
            b()
        }
    });
    $(".num .add").click(function () {
        let c = parseInt($(this).siblings("span").text());
        if (c >= 5) {
            confirm("限购5件")
        } else {
            c++;
            $(this).siblings("span").text(c);

            if ($(this).siblings("span").attr('datasrc')) {
                let url = "/cart_num?count=" + c + "&id=" + $(this).siblings("span").attr('datasrc');
                $.post(url, function () {
                });
            }
            let d = $(this).parents(".number").prev().text().substring(1);
            $(this).parents(".th").find(".sAll").text("￥" + (c * d).toFixed(2));
            a();
            b()
        }
    });

    function a() {
        let c = 0;
        let d = $(".th input[type='checkbox']:checked").length;
        if (d === 0) {
            $("#all").text(parseFloat("0").toFixed(2))
        } else {
            $(".th input[type='checkbox']:checked").each(function () {
                let e = $(this).parents(".pro").siblings(".sAll").text().substring(1);
                c += parseFloat(e);
                $("#all").text(c.toFixed(2))
            })
        }
    }

    function b() {
        let e = 0;
        let c = $(".th input[type='checkbox']:checked").parents(".th").find(".num span");
        let d = c.length;
        if (d === 0) {
            $("#sl").text(0)
        } else {
            c.each(function () {
                e += parseInt($(this).text());
                $("#sl").text(e)
            })
        }
        if ($("#sl").text() > 0) {
            $(".count").css("background", "#c10000")
        } else {
            $(".count").css("background", "#8e8e8e")
        }
    }

    $("input[type='checkbox']").on("click", function () {
        let c;
        let d;
        let f = $(this).is(":checked");
        let e = $(this).hasClass("checkAll");
        if (f) {
            if (e) {
                $("input[type='checkbox']").each(function () {
                    this.checked = true
                });
                b();
                a()
            } else {
                $(this).checked = true;
                c = $("input[type='checkbox']:checked").length;
                d = $("input").length - 1;
                if (c === d) {
                    $("input[type='checkbox']").each(function () {
                        this.checked = true
                    })
                }
                b();
                a()
            }
        } else {
            if (e) {
                $("input[type='checkbox']").each(function () {
                    this.checked = false
                });
                b();
                a()
            } else {
                $(this).checked = false;
                c = $(".th input[type='checkbox']:checked").length;
                d = $("input").length - 1;
                if (c < d) {
                    $(".checkAll").attr("checked", false)
                }
                b();
                a()
            }
        }
    });
    $(".btns .cart").click(function () {
        if ($(".categ p").hasClass("on")) {
            let c = parseInt($(".num span").text());
            let d = parseInt($(".goCart span").text());
            $(".goCart span").text(c + d)
        }
    });
});