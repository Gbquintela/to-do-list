(function() {
    'use strict';

    document.addEventListener('DOMContentLoaded', function() {
        const registerForm = document.getElementById('registerUserform');
        const submitButton = registerForm.querySelector('button[type="submit"]');

        // Máscara CPF (opcional)
        const cpfInput = document.getElementById('cpf');
        if (cpfInput) {
            cpfInput.addEventListener('input', formatCPF);
        }

        registerForm.addEventListener('submit', function(e) {
            e.preventDefault();

            // Desabilita o botão durante o cadastro
            submitButton.disabled = true;
            submitButton.textContent = 'Cadastrando...';

            // Validação básica - verifica se as senhas coincidem
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirmPassword').value;

            if (password !== confirmPassword) {
                alert('As senhas não coincidem!');
                submitButton.disabled = false;
                submitButton.textContent = 'Cadastrar';
                return;
            }

            // Envia os dados do formulário
            const formData = new FormData(registerForm);

            fetch(registerForm.action, {
                method: 'POST',
                body: formData
            })
                .then(response => {
                    if (response.ok) {
                        // MOSTRA O ALERTA DE SUCESSO
                        alert('Cadastro realizado com sucesso!');

                        // REDIRECIONA PARA A PÁGINA DE LOGIN
                        window.location.href = '/login';  // ← Altere esta rota se necessário
                    } else {
                        return response.text().then(text => {
                            alert(text || 'Erro ao registrar usuário');
                        });
                    }
                })
                .catch(error => {
                    alert('Erro na conexão: ' + error.message);
                })
                .finally(() => {
                    submitButton.disabled = false;
                    submitButton.textContent = 'Cadastrar';
                });
        });

        // Função para formatar CPF (opcional)
        function formatCPF(event) {
            let value = event.target.value.replace(/\D/g, '');
            if (value.length > 11) value = value.substring(0, 11);
            value = value.replace(/(\d{3})(\d)/, '$1.$2')
                .replace(/(\d{3})(\d)/, '$1.$2')
                .replace(/(\d{3})(\d{1,2})$/, '$1-$2');
            event.target.value = value;
        }
    });
})();