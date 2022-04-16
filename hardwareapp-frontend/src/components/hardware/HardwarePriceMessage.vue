<script setup lang="ts">
import { PhInfo } from "phosphor-vue";

type Props = {
  price: number;
};

const props = defineProps<Props>();

const message = computed(() => {
  if (props.price < 200) {
    return "Ovaj hardver se ne može kupiti na rate.";
  } else if (props.price < 500) {
    return "Ovaj hardver se može kupiti na 6 rata.";
  } else if (props.price < 900) {
    return "Ovaj hardver se može kupiti na 12 rata.";
  } else {
    return "Ovaj hardver se može kupiti na 24 rate.";
  }
});
</script>

<template>
  <n-alert title="Obročna uplata" type="info" h="full" weight="fill">
    <template #icon>
      <ph-info weight="fill" />
    </template>
    {{ message }}
  </n-alert>
</template>
