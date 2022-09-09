// place-carousel
const $ = str => document.querySelector(str);
const $$ = str => document.querySelectorAll(str);

(function() {
    if (!window.app) {
        window.app = {};
    }
    app.carousel = {
        removeClass: function(el, classname='') {
            if (el) {
                if (classname === '') {
                    el.className = '';
                } else {
                    el.classList.remove(classname);
                }
                return el;
            }
            return;
        },
        reorder: function() {
            let childcnt = $("#place-carousel").children.length;
            let childs = $("#place-carousel").children;

            for (let j=0; j< childcnt; j++) {
                childs[j].dataset.pos = j;
            }
        },
        move: function(el) {
            let selected = el;

            if (typeof el === "string") {
            console.log(`got string: ${el}`);
                selected = (el == "place-next") ? $(".place-selected").nextElementSibling : $(".place-selected").previousElementSibling;
                console.dir(selected);
            }

            let curpos = parseInt(app.selected.dataset.pos);
            let tgtpos = parseInt(selected.dataset.pos);

            let cnt = curpos - tgtpos;
            let dir = (cnt < 0) ? -1 : 1;
            let shift = Math.abs(cnt);

            for (let i=0; i<shift; i++) {
                let el = (dir == -1) ? $("#place-carousel").firstElementChild : $("#place-carousel").lastElementChild;

                if (dir == -1) {
                    el.dataset.pos = $("#place-carousel").children.length;
                    $('#place-carousel').append(el);
                } else {
                    el.dataset.pos = 0;
                    $('#place-carousel').prepend(el);
                }

                app.carousel.reorder();
            }


            app.selected = selected;
            let next = selected.nextElementSibling;// ? selected.nextElementSibling : selected.parentElement.firstElementChild;
            var prev = selected.previousElementSibling; // ? selected.previousElementSibling : selected.parentElement.lastElementChild;
            var prevSecond = prev ? prev.previousElementSibling : selected.parentElement.lastElementChild;
            var nextSecond = next ? next.nextElementSibling : selected.parentElement.firstElementChild;

            selected.className = '';
            selected.classList.add("place-selected");

            app.carousel.removeClass(prev).classList.add('place-prev');
            app.carousel.removeClass(next).classList.add('place-next');

            app.carousel.removeClass(nextSecond).classList.add("place-nextRightSecond");
            app.carousel.removeClass(prevSecond).classList.add("place-prevLeftSecond");

            app.carousel.nextAll(nextSecond).forEach(item=>{ item.className = ''; item.classList.add('place-hideRight') });
            app.carousel.prevAll(prevSecond).forEach(item=>{ item.className = ''; item.classList.add('place-hideLeft') });

        },
        nextAll: function(el) {
            let els = [];

            if (el) {
                while (el = el.nextElementSibling) { els.push(el); }
            }

            return els;

        },
        prevAll: function(el) {
            let els = [];

            if (el) {
                while (el = el.previousElementSibling) { els.push(el); }
            }


            return els;
        },
        keypress: function(e) {
            switch (e.which) {
                case 37: // left
                    app.carousel.move('place-prev');
                    break;

                case 39: // right
                    app.carousel.move('place-next');
                    break;

                default:
                    return;
            }
            e.preventDefault();
            return false;
        },
        select: function(e) {
        console.log(`place-select: ${e}`);
            let tgt = e.target;
            while (!tgt.parentElement.classList.contains('place-carousel')) {
                tgt = tgt.parentElement;
            }

            app.carousel.move(tgt);

        },
        previous: function(e) {
            app.carousel.move('place-prev');
        },
        next: function(e) {
            app.carousel.move('place-next');
        },
        doDown: function(e) {
        console.log(`down: ${e.x}`);
            app.carousel.state.downX = e.x;
        },
        doUp: function(e) {
        console.log(`up: ${e.x}`);
            let direction = 0,
                velocity = 0;

            if (app.carousel.state.downX) {
                direction = (app.carousel.state.downX > e.x) ? -1 : 1;
                velocity = app.carousel.state.downX - e.x;

                if (Math.abs(app.carousel.state.downX - e.x) < 10) {
                    app.carousel.select(e);
                    return false;
                }
                if (direction === -1) {
                    app.carousel.move('place-next');
                } else {
                    app.carousel.move('place-prev');
                }
                app.carousel.state.downX = 0;
            }
        },
        init: function() {
            document.addEventListener("keydown", app.carousel.keypress);
           // $('#carousel').addEventListener("click", app.carousel.select, true);
            $("#place-carousel").addEventListener("mousedown", app.carousel.doDown);
            $("#place-carousel").addEventListener("touchstart", app.carousel.doDown);
            $("#place-carousel").addEventListener("mouseup", app.carousel.doUp);
            $("#place-carousel").addEventListener("touchend", app.carousel.doup);

            app.carousel.reorder();
            $('#place-prev').addEventListener("click", app.carousel.previous);
            $('#place-next').addEventListener("click", app.carousel.next);
            app.selected = $(".place-selected");

        },
        state: {}

    }
    app.carousel.init();
})();