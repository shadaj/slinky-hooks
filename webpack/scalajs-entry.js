if (process.env.NODE_ENV === "production") {
    const opt = require("./slinky-hooks-opt.js");
    opt.entrypoint.main();
    module.exports = opt;
} else {
    var exports = window;
    exports.require = require("./slinky-hooks-fastopt-entrypoint.js").require;
    window.global = window;

    const fastOpt = require("./slinky-hooks-fastopt.js");
    fastOpt.entrypoint.main()
    module.exports = fastOpt;

    if (module.hot) {
        module.hot.accept();
    }
}
