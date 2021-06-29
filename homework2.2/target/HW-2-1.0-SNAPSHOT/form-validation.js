$(function() {
    // Initialize form validation on the registration form.
    // It has the name attribute "registration"
    $("form[name='registration']").validate({
        // Specify validation rules
        rules: {
            // The key name on the left side is the name attribute
            // of an input field. Validation rules are defined
            // on the right side
            amount: {
                required:true,
                digits: true,
                range: [0,1000000]
            },
            body: {
                required: true,
            },
        },
        // Specify validation error messages
        messages: {
            amount: {
                required: "Please provide an amount",
                digits: "Please provide a correct amount as a number",
                range:"Please provide an amount over 0",
            },
            body: "Please select at least one ",

        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});