import { getAllHardware } from "@/services/hardware";
import { useHardwareStore } from "@/stores/hardware";
import { set } from "@vueuse/core";

export const useHardwareFetch = () => {
  const store = useHardwareStore();
  const loading = ref(false);

  const fetchHardware = async () => {
    try {
      set(loading, true);
      const data = await getAllHardware();
      store.setHardware(data ?? []);
    } catch (err: any) {
      console.error(err.message, err);
      store.setHardware([]);
    } finally {
      set(loading, false);
    }
  };

  return {
    loading,
    fetchHardware,
  };
};
