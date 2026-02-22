Feature: Login Functionality SauceDemo

  # 1. TES POSITIF
  Scenario: Berhasil login dengan data yang benar
    Given Saya berada di halaman login SauceDemo
    When Saya memasukkan username "standard_user" dan password "secret_sauce"
    And Saya menekan tombol login
    Then Saya diarahkan ke halaman utama

  # 2. TES NEGATIF
  Scenario: Gagal login dengan data yang salah
    Given Saya berada di halaman login SauceDemo
    When Saya memasukkan username "user_salah" dan password "password_salah"
    And Saya menekan tombol login
    Then Saya melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  # 3. TES BATAS (Kosong)
  Scenario: Gagal login dengan mengosongkan username
    Given Saya berada di halaman login SauceDemo
    When Saya memasukkan username "" dan password "secret_sauce"
    And Saya menekan tombol login
    Then Saya melihat pesan error "Epic sadface: Username is required"