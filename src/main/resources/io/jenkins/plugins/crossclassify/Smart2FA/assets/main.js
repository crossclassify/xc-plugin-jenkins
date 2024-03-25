function handleSubmit(event){
    event.preventDefault()
    setTimeout(() => {
        event.target.submit()
    }, 1000);
}

window.onload = function() {
    let auth_form = document.querySelector('form');
    auth_form.setAttribute("custom-attribute", "include-form-tracking");

    if (!auth_form.hasAttribute('name')) {
        auth_form.setAttribute('name', 'signup');
    }

    // let emailInput = document.createElement('input');
    // emailInput.setAttribute("type", "hidden");
    // emailInput.setAttribute("name", "email");
    // emailInput.setAttribute("id", "email");
    // auth_form.appendChild(emailInput);
    //
    // const usernameInput = document.querySelector('[id*="username"]');
    // usernameInput.addEventListener('input', function() {
    //     emailInput.value = usernameInput.value;
    // });

    let inputs = document.querySelectorAll('input');
    inputs.forEach(function (input) {
        input.setAttribute("custom-attribute", "include-content-tracking");
    });

    let submit_btn = document.querySelector('button');
    submit_btn.setAttribute("custom-attribute", "form-submit");
    submit_btn.addEventListener('submit', handleSubmit);

    initXC(siteIdStored, apiKeyStored);
}
