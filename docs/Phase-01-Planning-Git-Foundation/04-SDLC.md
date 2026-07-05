# Software Development Life Cycle (SDLC)

**Project:** Enterprise DevOps Release Management Platform (ERMP)

**Document Version:** v1.0

**Author:** Naresh Shekkari

**Reviewer:** TBD

**Status:** Draft

**Last Updated:** July 2026

---

# 1. Objective

The objective of this document is to explain the Software Development Life Cycle (SDLC) and its importance in enterprise software development.

Understanding SDLC helps identify how software moves from a business idea to a production-ready application and where DevOps contributes to the process.

---

# 2. What is SDLC?

Software Development Life Cycle (SDLC) is a structured process used to plan, design, develop, test, deploy, and maintain software in a systematic and controlled manner.

It provides a standard approach that helps organizations deliver high-quality software while minimizing risk, cost, and development time.

---

# 3. Why is SDLC Important?

Organizations follow SDLC to:

- Improve software quality
- Reduce development risks
- Deliver projects on time
- Improve collaboration between teams
- Standardize software development
- Improve customer satisfaction

---

# 4. SDLC Phases

```text
Business Requirement
        │
        ▼
Planning
        │
        ▼
Design
        │
        ▼
Development
        │
        ▼
Testing
        │
        ▼
Deployment
        │
        ▼
Maintenance
```

---

## 4.1 Requirement Gathering

Purpose:

Understand business needs.

Deliverables:

- Business Requirement Document (BRD)
- Functional Requirements
- Non-Functional Requirements

Stakeholders:

- Business Team
- Product Owner
- Business Analyst
- Customer

---

## 4.2 Planning

Purpose:

Estimate project cost, timeline, resources, and risks.

Deliverables:

- Project Plan
- Budget
- Timeline
- Team Allocation

---

## 4.3 Design

Purpose:

Design the technical architecture.

Deliverables:

- High Level Design (HLD)
- Low Level Design (LLD)
- Database Design
- API Design

---

## 4.4 Development

Purpose:

Develop software features.

Activities:

- Coding
- Unit Testing
- Code Review
- Git Commit
- Pull Request

Deliverables:

- Source Code
- Unit Tests

---

## 4.5 Testing

Purpose:

Verify software quality.

Testing Types:

- Functional Testing
- Integration Testing
- Regression Testing
- Performance Testing
- Security Testing

Deliverables:

- Test Report
- Defect Report

---

## 4.6 Deployment

Purpose:

Deploy the application to production.

Activities:

- Build Docker Image
- Push Image to Amazon ECR
- Provision Infrastructure
- Configure Servers
- Deploy to Kubernetes
- Validate Health Checks

Deliverables:

- Production Release
- Release Notes

---

## 4.7 Maintenance

Purpose:

Support production systems after deployment.

Activities:

- Bug Fixes
- Performance Improvements
- Version Upgrades
- Security Updates
- Monitoring

---

# 5. SDLC Models

| Model | Common Usage |
|---------|--------------|
| Waterfall | Traditional Projects |
| Agile | Modern Software Development |
| Scrum | Agile Framework |
| Spiral | High-Risk Projects |
| V-Model | Testing-Focused Projects |
| Iterative | Continuous Improvement |

This project follows the Agile + Scrum + DevOps model.

---

# 6. SDLC in Our Project

Our project follows these SDLC stages:

Business Requirement

↓

Planning

↓

Architecture Design

↓

Application Development

↓

Testing

↓

CI/CD Pipeline

↓

Production Deployment

↓

Monitoring

↓

Continuous Improvement

---

# 7. SDLC vs DevOps

| SDLC | DevOps |
|------|---------|
| Focuses on software development | Focuses on software delivery |
| Defines development stages | Automates and accelerates delivery |
| Ends after deployment | Continues with monitoring and feedback |
| May include manual activities | Emphasizes automation |

---

# 8. Best Practices

- Define requirements clearly.
- Review designs before implementation.
- Follow coding standards.
- Automate testing.
- Automate deployments.
- Monitor production continuously.
- Maintain complete documentation.

---

# 9. Common Mistakes

- Skipping requirement analysis.
- Poor planning.
- Insufficient testing.
- Manual deployments.
- Lack of monitoring.
- No rollback strategy.

---

# 10. Interview Questions

1. What is SDLC?
2. Why do organizations follow SDLC?
3. Explain the phases of SDLC.
4. Difference between SDLC and DevOps.
5. Which SDLC model does your organization follow?
6. Where does DevOps fit into SDLC?

---

# 11. Conclusion

Software Development Life Cycle (SDLC) provides a structured framework for delivering software efficiently and reliably.

In this project, SDLC serves as the foundation, while DevOps practices automate and optimize software delivery, ensuring faster releases, improved quality, and better collaboration across teams.