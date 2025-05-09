document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.querySelector('form');
    const cpfInput = document.getElementById('cpf');

    // Adiciona máscara ao CPF
    cpfInput.addEventListener('input', function() {
        let value = this.value.replace(/\D/g, '');

        if (value.length > 3) {
            value = value.substring(0, 3) + '.' + value.substring(3);
        }
        if (value.length > 7) {
            value = value.substring(0, 7) + '.' + value.substring(7);
        }
        if (value.length > 11) {
            value = value.substring(0, 11) + '-' + value.substring(11);
        }

        this.value = value.substring(0, 14);
    });

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Impede o envio padrão do formulário

        // Obtém os valores dos campos
        const emailInput = document.getElementById('cpf');
        const passwordInput = document.getElementById('password');

        // Validação básica
        if (!validateCPF(cpfInput.value) || !validatePassword(passwordInput.value)) {
            return false;
        }

        // Se a validação passar, pode enviar o formulário
        this.submit();
    });
});