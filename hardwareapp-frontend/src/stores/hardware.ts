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
      code: "CMW32GX4M2D3600C18",
      name: "CORSAIR Vengeance RGB Pro 32GB",
      price: 124.99,
    },
    {
      code: "N82E16814932443",
      name: "GIGABYTE Gaming GeForce RTX 3070 Ti",
      price: 858.33,
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
