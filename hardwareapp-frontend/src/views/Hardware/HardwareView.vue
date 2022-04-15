<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";
import { useHardwareStore } from "@/stores/hardware";

const router = useRouter();
const store = useHardwareStore();

store.fetchHardware();

const gotoHardwareItem = ({ code }: HardwareDTO) =>
  router.push({
    name: "HardwareItem",
    params: { code },
  });
</script>

<template>
  <div>
    <NH1 prefix="bar" type="success" mb="8">
      <NText>Available hardware</NText>
    </NH1>
    <div flex="~ col-reverse lg:row gap-2 lg:gap-12">
      <HardwareList
        w="full"
        max-w="lg:100"
        :items="store.hardware"
        @select="gotoHardwareItem"
      />
    </div>
  </div>
</template>
