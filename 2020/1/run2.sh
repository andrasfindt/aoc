while IFS="" read -r p || [ -n "$p" ]; do
  while read q; do
    while read r; do
      s=$((p + q + r))
      if [ $s -eq 2020 ]; then
        printf '%d + %d + %d = %d\n' "$p" "$q" "$r" "$s"
        printf '%d * %d * %d = %d\n' "$p" "$q" "$r" "$((p * q * r))"
        exit 0
      fi
    done <input.txt
  done <input.txt
done <input.txt
