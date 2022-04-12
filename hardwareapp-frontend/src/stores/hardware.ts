import type { HardwareDTO } from "@/models/hardware";

export const useHardwareStore = defineStore("hardware", () => {
  const hardware: HardwareDTO[] = [
    {
      code: "BX8071512700K",
      name: "Intel Core i7-12700K",
      price: 384.98,
    },
    {
      code: "BX8071512900K",
      name: "Intel Core i9-12900K",
      price: 614.99,
    },
    {
      code: "N82E16819113683",
      name: "AMD Ryzen 5 5600GE",
      price: 220,
    },
    {
      code: "N82E16819113664",
      name: "AMD Ryzen 9 5900X ",
      price: 395,
    },
    {
      code: "N82E16819113665",
      name: "AMD Ryzen 7 5800X",
      price: 359,
    },
    {
      code: "N82E16814932443",
      name: "GIGABYTE Gaming GeForce RTX 3070 Ti",
      price: 858.33,
    },
    {
      code: "MZV7S500BAM",
      name: "SAMSUNG 970 EVO PLUS",
      price: 69.99,
    },
    {
      code: "WDS100T1X0E",
      name: "Western Digital WD BLACK SN850",
      price: 149.99,
    },
    {
      code: "BLM2K8G44C19U4B",
      name: "Crucial Ballistix MAX 4400 MHz",
      price: 79.99,
    },
    {
      code: "N82E16820232880",
      name: "G.SKILL Ripjaws V Series 16GB DDR4",
      price: 85.99,
    },
    {
      code: "N82E16820821488",
      name: "OLOy Blade RGB 32GB DDR5",
      price: 309.99,
    },
    {
      code: "CMW32GX4M2D3600C18",
      name: "CORSAIR Vengeance RGB Pro 32GB",
      price: 124.99,
    },
    {
      code: "N82E16813119500",
      name: "Asus ROG STRIX B550-F",
      price: 229.99,
    },
    {
      code: "N82E16813119504",
      name: "ASUS ROG Maximus Z690 Hero",
      price: 599.99,
    },
  ];

  const getHardwareByCode = (code: string) =>
    hardware?.find((h) => h.code === code) || null;

  return {
    hardware,
    getHardwareByCode,
  };
});

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(useHardwareStore, import.meta.hot));
