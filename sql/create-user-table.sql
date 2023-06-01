CREATE DATABASE E_Ticaret;
USE E_Ticaret;

CREATE TABLE Kullanicilar (
    KullaniciID INT PRIMARY KEY,
    KullaniciAdi VARCHAR(255),
    Sifre VARCHAR(255)
);


CREATE TABLE Urunler (
    UrunID INT PRIMARY KEY,
    KategoriID INT,
    UrunAdi VARCHAR(255),
    StokMiktari INT,
    FOREIGN KEY (KategoriID) REFERENCES Kategoriler(KategoriID)
);


CREATE TABLE Kategoriler (
    KategoriID INT PRIMARY KEY,
    KategoriAdi VARCHAR(255)
);


CREATE TABLE Siparisler (
    SiparisID INT PRIMARY KEY,
    KullaniciID INT,
    Tarih DATE,
    FOREIGN KEY (KullaniciID) REFERENCES Kullanicilar(KullaniciID)
);


CREATE TABLE SiparisDetaylari (
    SiparisDetayID INT PRIMARY KEY,
    SiparisID INT,
    UrunID INT,
    Miktar INT,
    FOREIGN KEY (SiparisID) REFERENCES Siparisler(SiparisID),
    FOREIGN KEY (UrunID) REFERENCES Urunler(UrunID)
);
