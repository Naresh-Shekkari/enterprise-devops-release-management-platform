# Git Branching Strategy

**Project:** Enterprise DevOps Release Management Platform (ERMP)

**Company:** ABC Bank Pvt Ltd

**Document Version:** v1.0

**Author:** Naresh Shekkari

---

# 1. Objective

The purpose of this document is to define the Git branching strategy used in the Enterprise DevOps Release Management Platform (ERMP).

A proper branching strategy ensures:

- Parallel development
- Controlled releases
- Stable production code
- Easy bug fixing
- Safe collaboration
- Faster deployments
- Simplified rollback

---

# 2. Why Do We Need a Branching Strategy?

Imagine 50 developers working on the same repository.

Developer A is building Login.

Developer B is building Payments.

Developer C is fixing a Production Bug.

Developer D is implementing UPI.

If everyone commits directly to the main branch:

❌ Code conflicts

❌ Broken builds

❌ Production failures

❌ Difficult rollbacks

A branching strategy solves these problems.

---

# 3. Branch Types

Our project uses the following branches:

```

main

develop

feature/*

release/*

hotfix/*

bugfix/*

```

Each branch has a specific purpose.

---

# 4. Branch Architecture

```

                          main
                            │
            ┌───────────────┴───────────────┐
            │                               │
         release/v1.0                 hotfix/v1.0.1
            │
            ▼
         develop
      ┌─────┼─────┐
      │     │     │
feature feature feature
/login /payment /upi

```

---

# 5. Main Branch

Purpose:

- Production-ready code only.
- Always stable.
- Protected branch.
- No direct commits allowed.

Examples:

```

main

```

Rules:

- Pull Request required
- Minimum two reviewers
- CI pipeline must pass
- Security scan must pass

---

# 6. Develop Branch

Purpose:

Integration branch for all completed features.

Developers merge completed work here.

Example:

```

develop

```

This branch is deployed to the Development environment.

---

# 7. Feature Branch

Purpose:

Used for new feature development.

Examples:

```

feature/login

feature/payment

feature/dashboard

feature/notifications

feature/user-management

```

Workflow:

```

develop

↓

feature/login

↓

Commit

↓

Pull Request

↓

Merge into develop

```

---

# 8. Release Branch

Purpose:

Prepare a production release.

Example:

```

release/v1.0.0

release/v1.1.0

release/v2.0.0

```

Activities:

- Final testing
- Documentation
- Bug fixes
- Version update

No new features are added.

---

# 9. Hotfix Branch

Purpose:

Fix production issues immediately.

Example:

```

hotfix/login-timeout

hotfix/payment-failure

hotfix/session-expiry

```

Workflow:

```

main

↓

hotfix/payment

↓

Fix

↓

Merge main

↓

Merge develop

```

---

# 10. Bugfix Branch

Purpose:

Fix non-production defects.

Example:

```

bugfix/profile

bugfix/dashboard

```

These branches merge into develop.

---

# 11. Branch Lifecycle

```

Create Feature Branch

↓

Development

↓

Commit

↓

Push

↓

Pull Request

↓

Code Review

↓

Merge into develop

↓

Testing

↓

Release Branch

↓

UAT

↓

Production

↓

main

```

---

# 12. Naming Standards

Feature

```

feature/login

feature/payment

feature/customer-api

```

Bug

```

bugfix/profile

bugfix/search

```

Release

```

release/v1.0.0

release/v1.1.0

```

Hotfix

```

hotfix/payment

hotfix/login

```

---

# 13. Pull Request Process

Developer pushes feature branch.

↓

Creates Pull Request.

↓

Automated checks start.

- Build
- Unit Test
- SonarQube
- Security Scan

↓

Senior Developer reviews.

↓

Changes requested (if required).

↓

Approved.

↓

Merged into develop.

---

# 14. Merge Strategy

We use:

**Squash and Merge** for feature branches.

Benefits:

- Clean commit history
- Easy rollback
- Better readability

Release branches use **Merge Commit** to preserve release history.

---

# 15. Branch Protection Rules

Protected Branches:

- main
- develop

Rules:

- No force push
- No direct commit
- Pull Request mandatory
- CI pipeline mandatory
- At least two approvals
- Status checks required
- Branch must be up-to-date

---

# 16. Versioning Strategy

We follow Semantic Versioning.

Format:

```

MAJOR.MINOR.PATCH

```

Examples:

```

1.0.0

1.0.1

1.1.0

2.0.0

```

Meaning:

| Version | Meaning |
|----------|---------|
| Major | Breaking changes |
| Minor | New features |
| Patch | Bug fixes |

---

# 17. Real Production Example

Requirement:

Add QR Payment feature.

Step 1

Create branch:

```

feature/qr-payment

```

↓

Developer writes code.

↓

Git Commit.

↓

Git Push.

↓

Pull Request.

↓

Jenkins Pipeline executes.

↓

QA Testing.

↓

Merge into develop.

↓

Release branch:

```

release/v2.1.0

```

↓

Production deployment.

↓

Merge into main.

---

# 18. Rollback Strategy

Suppose version 2.1.0 fails.

Rollback steps:

```

Current

v2.1.0

↓

Problem detected

↓

Rollback

↓

Deploy v2.0.5

↓

Users continue normally

```

Git Tag:

```

v2.0.5

```

---

# 19. Git Tags

Every production release is tagged.

Examples:

```

v1.0.0

v1.0.1

v1.1.0

v2.0.0

```

Benefits:

- Easy rollback
- Version tracking
- Release history

---

# 20. CI/CD Integration

Every branch triggers a different pipeline.

| Branch | Environment |
|----------|-------------|
| feature/* | Dev |
| develop | Integration |
| release/* | UAT |
| main | Production |
| hotfix/* | Production Emergency |

---

# 21. Team Responsibilities

| Role | Responsibility |
|------|----------------|
| Developer | Create feature branches and raise PRs |
| Senior Developer | Review code |
| QA Engineer | Validate functionality |
| DevOps Engineer | Maintain CI/CD pipeline |
| Release Manager | Approve production release |

---

# 22. Best Practices

- Never commit directly to `main`.
- Keep feature branches short-lived.
- Create small, focused Pull Requests.
- Rebase feature branches regularly.
- Tag every production release.
- Delete merged branches.
- Protect critical branches.
- Review every Pull Request.

---

# 23. Common Mistakes

❌ Direct commits to `main`.

❌ Long-running feature branches.

❌ Force pushes on protected branches.

❌ Large Pull Requests with unrelated changes.

❌ Skipping code reviews.

❌ Deploying untagged releases.

❌ Not merging hotfixes back into `develop`.

---

# 24. Interview Questions

1. What branching strategy does your project use?
2. What is GitFlow?
3. Difference between `main` and `develop`.
4. Why use feature branches?
5. What is a hotfix branch?
6. Why create release branches?
7. What is branch protection?
8. Explain Squash Merge.
9. Explain Semantic Versioning.
10. How do you rollback a release?
11. What happens after a Pull Request is created?
12. Which branch triggers the production deployment?

---

# 25. Key Takeaways

- A branching strategy enables multiple developers to work safely in parallel.
- `main` always contains production-ready code.
- `develop` integrates completed features before release.
- Feature, release, hotfix, and bugfix branches isolate different types of work.
- Pull Requests, branch protection, CI/CD validation, and code reviews ensure software quality and reduce deployment risks.
- Semantic versioning and Git tags make releases traceable and simplify rollback.

---

# 26. Git Strategy Used in Our ERMP Project

| Branch | Purpose | Deployment Target |
|---------|---------|-------------------|
| main | Production | Production (AWS EKS) |
| develop | Integration | Development Environment |
| feature/* | New Feature Development | Developer Testing |
| bugfix/* | Bug Fixes | Development |
| release/* | Release Validation | UAT |
| hotfix/* | Emergency Production Fix | Production |

---

# 27. Conclusion

The ERMP project follows a modified GitFlow branching strategy to support enterprise-scale collaboration, automated CI/CD pipelines, controlled releases, and safe production deployments. By enforcing branch protection, mandatory code reviews, semantic versioning, and release tagging, the project ensures high-quality software delivery while minimizing production risk.