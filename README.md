# qr-wallet-payment
QR Code Scan and Transfer payment to merchant through Wallet, Backend Code Only

qr-wallet-payment/
├── src/main/java/com/example/qrwallet
│   ├── controller/    # REST API Controllers (Exposes Endpoints)
│   ├── dto/           # Data Transfer Objects (For API Requests & Responses)
│   ├── entity/        # JPA Entities (Database Models)
│   ├── exception/     # Custom Exceptions (Error Handling)
│   ├── repository/    # Data Access Layer (Database Operations)
│   ├── service/       # Business Logic Layer (Core Application Logic)
│   ├── utils/         # Utility Classes (QR Code Generator, Helpers)
│   ├── QrWalletApplication.java  # Main Spring Boot Application
│
├── src/main/resources/
│   ├── application.properties  # Configuration File (Database, Server Settings)
│
└── pom.xml                     # Maven Dependencies



We are using H2
http://localhost:8080/h2-console/login.do?jsessionid=db4d65402cf9aa0e597924aefdda2754

