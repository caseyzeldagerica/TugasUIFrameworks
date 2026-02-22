# Web UI Automation Framework (Selenium, Cucumber, Gradle)

Proyek ini adalah framework otomasi pengujian UI Web menggunakan Java, Selenium WebDriver, Cucumber (BDD), dan dikelola dengan Gradle. Proyek ini juga menerapkan arsitektur Page Object Model (POM).

## Teknologi yang Digunakan
- **Bahasa:** Java
- **Build Tool:** Gradle
- **Testing Framework:** JUnit & Cucumber
- **Automation Tool:** Selenium WebDriver

## Struktur Proyek
- `src/test/java/pages/`: Berisi implementasi Page Object Model (POM) untuk memisahkan logika halaman (contoh: `LoginPage.java`).
- `src/test/java/steps/`: Berisi Step Definitions untuk menerjemahkan Gherkin menjadi kode eksekusi Selenium.
- `src/test/resources/features/`: Berisi file skenario pengujian Gherkin (`.feature`) mencakup Tes Positif, Negatif, dan Batas (Boundary).
- `src/test/java/TestRunner.java`: File eksekusi utama yang juga akan men-generate laporan HTML.

## Cara Menjalankan Tes
1. Clone repositori ini ke komputer lokal Anda.
2. Buka proyek menggunakan IntelliJ IDEA (atau IDE lain yang mendukung Gradle).
3. Tunggu Gradle mengunduh semua dependensi.
4. Buka file `src/test/java/TestRunner.java` lalu jalankan (Run).
5. Laporan hasil pengujian akan otomatis dibuat dan dapat dilihat di `target/Laporan-Cucumber.html`.