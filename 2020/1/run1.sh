while IFS="" read -r p || [ -n "$p" ]; do
  while read r; do
    s=$((p + r))
    if [ $s -eq 2020 ]; then
      printf '%d + %d = %d\n' "$p" "$r" "$s"
      printf '%d * %d = %d\n' "$p" "$r" "$((p * r))"
      exit 0
    fi
  done <input.txt
done <input.txt
