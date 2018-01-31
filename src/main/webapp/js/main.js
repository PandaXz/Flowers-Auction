function relocate(loc) {
    location=loc;
}

function now(field) {
    field.setAttribute("min",(new Date()).toISOString())
}