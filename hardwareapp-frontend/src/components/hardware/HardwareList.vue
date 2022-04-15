<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";

type Props = {
  items: HardwareDTO[];
};

defineProps<Props>();

const router = useRouter();

const gotoHardwareItem = ({ code }: HardwareDTO) =>
  router.push({
    name: "HardwareItem",
    params: { code },
  });
</script>

<template>
  <ul flex="~ col gap-2" max-h="lg:75vh" pr="2" overflow="auto">
    <HardwareListItem
      v-for="item in items"
      :key="item.code"
      :item="item"
      @click="gotoHardwareItem(item)"
    />
  </ul>
</template>
