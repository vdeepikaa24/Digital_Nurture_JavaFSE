# TODO - JWT Generation Checklist

- [x] Align AuthenticationController JWT generation with current jjwt 0.12.x dependencies.
- [ ] Remove deprecated/dead code that references JwtBuilder (jjwt 0.12.x API mismatch).
- [ ] Update AuthenticationController.generateJwt to use non-deprecated `signWith(Key)`.
- [ ] Remove unused/incorrect imports (e.g., SignatureAlgorithm).
- [ ] Run `mvn test` (and optionally `mvn package`) to confirm build is clean.
- [ ] Smoke test endpoint: `curl -s -u user:pwd http://localhost:8090/authenticate` and verify `token` field exists.

