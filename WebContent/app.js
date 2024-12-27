const API_URL = 'http://localhost:8080/api/planets';

// Fetch and display planets
async function fetchPlanets() {
    const response = await fetch(API_URL);
    const planets = await response.json();
    const planetList = document.getElementById('planet-list');

    planetList.innerHTML = planets.map(planet => `
        <tr>
            <td>${planet.name}</td>
            <td>${planet.mass}</td>
            <td>${planet.diameter}</td>
            <td>${planet.numberOfMoons}</td>
            <td>${planet.description}</td>
            <td>
                <button class="btn btn-danger btn-sm" onclick="deletePlanet(${planet.id})">Delete</button>
                <button class="btn btn-warning btn-sm" onclick="editPlanet(${planet.id})">Edit</button>
            </td>
        </tr>
    `).join('');
}

// Add a new planet
async function addPlanet() {
    const name = document.getElementById('name').value;
    const mass = document.getElementById('mass').value;
    const diameter = document.getElementById('diameter').value;
    const moons = document.getElementById('moons').value;
    const description = document.getElementById('description').value;

    const planet = { name, mass, diameter, numberOfMoons: moons, description };

    await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(planet),
    });

    fetchPlanets();
    document.getElementById('planet-form').reset();
}

// Delete a planet
async function deletePlanet(id) {
    await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
    fetchPlanets();
}

// Edit a planet
async function editPlanet(id) {
    const response = await fetch(`${API_URL}/${id}`);
    const planet = await response.json();

    document.getElementById('update-id').value = planet.id;
    document.getElementById('update-name').value = planet.name;
    document.getElementById('update-mass').value = planet.mass;
    document.getElementById('update-diameter').value = planet.diameter;
    document.getElementById('update-moons').value = planet.numberOfMoons;
    document.getElementById('update-description').value = planet.description;

    document.getElementById('update-form-container').style.display = 'block';
}

// Update a planet
async function updatePlanet() {
    const id = document.getElementById('update-id').value;
    const name = document.getElementById('update-name').value;
    const mass = document.getElementById('update-mass').value;
    const diameter = document.getElementById('update-diameter').value;
    const moons = document.getElementById('update-moons').value;
    const description = document.getElementById('update-description').value;

    const planet = { name, mass, diameter, numberOfMoons: moons, description };

    await fetch(`${API_URL}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(planet),
    });

    document.getElementById('update-form-container').style.display = 'none';
    fetchPlanets();
}

// Initial load
document.addEventListener('DOMContentLoaded', fetchPlanets);
