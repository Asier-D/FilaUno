/*<![CDATA[*/

//const usuarioId = /*[[${usuario != null ? usuario.id : null}]]*/ null; //pq procesa bien el null en este caso

// el CDATA ayuda a que /*[[${usuario.orElse(null)?.id}]]*/
//Sea procesada correctamente por Thymeleaf
//No rompa el HTML/JS si el valor inyectado tiene caracteres especiales
//Y finalmente asigna usuarioId correctamente, o null si no hay usuario.

let roles = [];
let rolesDisponibles = [];


// Función para obtener el CSRF token, que se usa para las peticiones AJAX (son peticiones que hacemos del java al servidor, sin tener que cargar otra vez la ventana)
function getCsrfToken() {
	const token = document.querySelector('meta[name="_csrf"]');
	return token ? token.getAttribute('content') : null;
}

function getCsrfHeader() {
	const header = document.querySelector('meta[name="_csrf_header"]');
	return header ? header.getAttribute('content') : 'X-CSRF-TOKEN';
}

// Mostrar alertas
function showAlert(message, type = 'success') {
	const alertContainer = document.getElementById('alertContainer');
	const alert = document.createElement('div');
	alert.className = `alert alert-${type}`;
	alert.textContent = message;
	alertContainer.appendChild(alert);
	
	setTimeout(() => {
		alert.remove();
	}, 4000);
}

//cargar roles de usuario
function renderRoles(){
	const rolesList = document.getElementById('rolesList');
	const emptyState = document.getElementById('emptyState');
	
	if(!rolesList){
		rolesList.innerHTML = '';
		emptyState.style.display = 'block';
		return;
	}

	emptyState && (emptyState.style.display = roles.length === 0 ? 'block' : 'none');
	rolesList.innerHTML = roles
		.filter(ur => ur && ur.rol) // <-- evita null
		.map(ur => `
			<div class="role-card">
				<button class="btn-delete-role" onclick="deleteRole(${ur.rol.id})"></button>
				<h5>Rol: <span>${ur.rol.nombre}</span></h5>
				<h5>Descripción: <span>${ur.rol.descripcion}</span></h5>
			</div>
		`).join('');

}
// Cargar roles del usuario
async function loadUserRoles() {
    try {
		console.log('usuarioId =', usuarioId);
		        console.log('URL fetch =', `/api/usuarios/${usuarioId}/roles`);
        const response = await fetch(`/api/usuarios/${usuarioId}/roles`);
        console.log('response.status =', response.status);
        console.log('response.ok =', response.ok);

        if (!response.ok) {
            const text = await response.text();
            console.error('Respuesta del servidor:', text);
            throw new Error('Error al cargar roles');
        }

        roles = await response.json();
        console.log('Roles cargados:', roles);
        renderRoles();
    } catch (error) {
        console.error('Error en loadUserRoles():', error);
        showAlert('Error al cargar los roles del usuario', 'error');
    }
}

// Cargar roles disponibles para asignar
async function loadAvailableRoles() {
	try {
		const response = await fetch('/api/roles');
		if (!response.ok) throw new Error('Error al cargar roles disponibles');
		rolesDisponibles = await response.json();
		
		const select = document.getElementById('roleSelect');
		select.innerHTML = '<option value="">-- Selecciona un rol --</option>' +
			rolesDisponibles.map(rol => 
				 `<option value="${rol.id}">${rol.nombre} - ${rol.descripcion}</option>`
			).join('');
	} catch (error) {
		console.error('Error:', error);
		showAlert('Error al cargar roles disponibles', 'error');
	}
}

// Abrir modal
function openModal() {
	document.getElementById('roleModal').style.display = 'block';
	loadAvailableRoles();
}

// Cerrar modal
function closeModal() {
	document.getElementById('roleModal').style.display = 'none';
	document.getElementById('roleForm').reset();
	document.getElementById('submitBtn').disabled = false;
}

// Añadir rol al usuario
async function addRole(event) {
	event.preventDefault();

		const rolId = parseInt(document.getElementById('roleSelect').value);
		const submitBtn = document.getElementById('submitBtn');

		if (!rolId) {
			showAlert('Por favor selecciona un rol', 'error');
			return;
		}

		submitBtn.disabled = true;
		submitBtn.innerHTML = 'Asignando... <span class="loading"></span>';

		try {
			const csrfToken = getCsrfToken();
			const headers = { 'Content-Type': 'application/json' };
			if (csrfToken) headers[getCsrfHeader()] = csrfToken;

			const response = await fetch(`/api/usuarios/${usuarioId}/roles`, {
				method: 'POST',
				headers,
				body: JSON.stringify({ rolId })
			});

			if (!response.ok) {
				const errorData = await response.json();
				throw new Error(errorData.message || 'Error al añadir rol');
			}

			// Recargar roles desde el backend
			await loadUserRoles();

			closeModal();
			showAlert('✓ Rol añadido correctamente', 'success');
		} catch (error) {
			console.error('Error:', error);
			showAlert('✗ ' + error.message, 'error');
			submitBtn.disabled = false;
			submitBtn.textContent = 'Asignar Rol';
		}
}

// Eliminar rol del usuario
async function deleteRole(rolId) {
	if (!confirm('¿Estás seguro de que deseas eliminar este rol?')) return;

	    try {
	        const csrfToken = getCsrfToken();
	        const headers = {};
	        if (csrfToken) headers[getCsrfHeader()] = csrfToken;

	        const response = await fetch(`/api/usuarios/${usuarioId}/roles/${rolId}`, {
	            method: 'DELETE',
	            headers: headers
	        });

	        if (!response.ok) {
	            const errorData = await response.json();
	            throw new Error(errorData.message || 'Error al eliminar rol');
	        }

	        // Ajustar según la estructura de tu JSON
	        roles = roles.filter(r => (r.rol?.id || r.id) !== rolId);
	        renderRoles();
	        showAlert('Rol eliminado correctamente', 'success');
	    } catch (error) {
	        console.error('Error:', error);
	        showAlert('✗ Error al eliminar rol', 'error');
	    }
}

// Cerrar modal al hacer clic fuera
window.onclick = function(event) {
	const modal = document.getElementById('roleModal');
	if (event.target === modal) {
		closeModal();
	}
}

document.addEventListener('DOMContentLoaded', () => {
    if (usuarioId) {
        loadUserRoles();
    } else {
        console.log('usuarioId =', usuarioId);
        showAlert('Error: No se pudo identificar al usuario', 'error');
    }
});

/*]]>*/