# E-Commerce Application (Internship Project)

This project was built using Java, Spring Boot, and JPA. It simulates the backend system of an online shopping platform and includes various customer- and admin-focused features. It simulates the backend system of an online shopping platform and includes various customer- and admin-focused features.

## Key Features:

### Entities and Relationships:
The application revolves around the following core entities, structured using a one-to-many relationship:

- **Users**: Represents customers who can register, log in, and place orders.
- **Orders**: Represents customer orders, each linked to a specific user. Each order can contain multiple products.
- **Products**: Represents items that are available for purchase. Admins manage these products, adding or updating product information.
- **OrderProduct**: Represents the many-to-many relationship between orders and products. It tracks the quantity of each product ordered in an order.

The relationships are modeled as follows:

- **One-to-many**: One user can place many orders. One order can have many order products, which link to many products.

These relationships are essential for simulating real-world e-commerce functionality, where a user can place multiple orders, each of which may contain multiple products.

### User Management:

- Customers can create accounts, log in securely, and place orders.
- Role-based access control ensures that only admins can manage products and orders, while customers can only place orders and view their history.

### Product Management:

- Admins can add, edit, and delete products. They can also categorize products to make them more accessible for customers.

### Shopping Cart:

- Customers can add products to their shopping cart and proceed to checkout, where the cart contents are updated dynamically.

### Order Management:

- Orders can be tracked with statuses like `PENDING`, `COMPLETED`, and `CANCELLED`. Users can modify or cancel orders before finalization.

### Payment and Refund System:

- Secure payment processing and tracking of payment statuses (Paid, Pending, Refunded).
- Refunds can be initiated for cancelled or returned orders, with transaction updates.

### Order History:

- Customers can view their past orders, including product details, payment statuses, and order statuses.

### Admin Dashboard:

- Admins can manage product listings, monitor orders, and track payment and refund transactions.

## Further Enhancements:

- Integration of an advanced recommendation system based on order history and product preferences.
- Improved order tracking with real-time updates via notifications or emails.
- Enhanced refund handling with integration to payment gateways for smoother processing.
