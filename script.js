document.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8081/api/orders') // ✅ correct port
        .then(response => response.json())
        .then(data => {
            const orderList = document.getElementById('order-list');

            if (!data || data.length === 0) {
                orderList.innerHTML = "<li>No orders found.</li>";
                return;
            }

            data.forEach(order => {
                const li = document.createElement('li');
                li.className = "order-item";
                li.innerHTML = `
                    <h3>${order.productName}</h3>
                    <p><strong>Customer:</strong> ${order.customerName}</p>
                    <p><strong>Quantity:</strong> ${order.quantity}</p>
                    <p><strong>Price:</strong> ₹${order.price}</p>
                    <p><strong>Order Date:</strong> ${order.orderDate}</p>
                `;
                orderList.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Error fetching orders:', error);
        });
});