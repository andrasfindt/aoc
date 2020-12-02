# shellcheck disable=SC2094
while IFS="" read -r p || [ -n "$p" ]; do
  while read -r q; do
    while read -r r; do
      s=$((p + q + r))
      if [ $s -eq 2020 ]; then
        printf '%d + %d + %d = %d\n' "$p" "$q" "$r" "$s"
        printf '%d * %d * %d = %d\n' "$p" "$q" "$r" "$((p * q * r))"
        exit 0
      fi
    done <input.txt
  done <input.txt
done <input.txt
