import type { Hardware, HardwareDTO } from "@/models/hardware";
import { addHardware } from "@/services/hardware";
import { set } from "@vueuse/core";

export const useItemAdd = () => {
  const loading = ref(false);
  const item = ref<HardwareDTO | null>();

  const createItem = async (hardwareData: Hardware) => {
    set(loading, true);
    try {
      const hardware = await addHardware(hardwareData);
      set(item, hardware ?? null);
    } catch (err: any) {
      console.error("Error adding hardware", err);
      set(item, null);
    } finally {
      set(loading, false);
    }
  };

  return {
    loading,
    item,
    createItem,
  };
};
