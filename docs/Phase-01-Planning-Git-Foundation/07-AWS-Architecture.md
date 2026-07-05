# AWS Architecture

**Project:** Enterprise DevOps Release Management Platform (ERMP)

**Company:** ABC Bank Pvt Ltd

**Version:** 1.0

**Author:** Naresh Shekkari

**Cloud Platform:** Amazon Web Services (AWS)

---

# 1. Objective

The purpose of this document is to explain the AWS architecture used in our Enterprise DevOps Release Management Platform (ERMP).

This document covers:

- AWS Global Infrastructure
- VPC Design
- Public & Private Subnets
- Internet Gateway
- NAT Gateway
- EC2
- IAM
- Security Groups
- Application Load Balancer
- Amazon ECR
- Amazon EKS
- Amazon RDS
- Route53
- Monitoring
- Logging
- High Availability
- Disaster Recovery
- Production Best Practices

---

# 2. Why AWS?

ABC Bank requires a cloud platform that provides:

- High Availability
- Scalability
- Security
- Disaster Recovery
- Pay-as-you-go pricing
- Global Availability

AWS satisfies all these requirements.

---

# 3. AWS Global Infrastructure

AWS infrastructure is organized into:

```

AWS

│

├── Region

│

├── Availability Zone (AZ)

│

├── Availability Zone (AZ)

│

└── Availability Zone (AZ)

```

Example

```

Region

ap-south-1 (Mumbai)

│

├── ap-south-1a

├── ap-south-1b

└── ap-south-1c

```

Production applications should use multiple Availability Zones.

---

# 4. Our AWS Architecture

```

                        Internet

                            │

                            ▼

                     Amazon Route53

                            │

                            ▼

                 Application Load Balancer

                            │

        ┌───────────────────┴────────────────────┐

        ▼                                        ▼

   Amazon EKS Node-1                       Amazon EKS Node-2

        │                                        │

        └──────────────┬─────────────────────────┘

                       ▼

                 Banking Application Pods

                       │

                       ▼

                 Amazon RDS (MySQL)

```

---

# 5. AWS Services Used

| Service | Purpose |
|----------|----------|
| EC2 | Virtual Machines |
| IAM | Identity Management |
| VPC | Private Network |
| Security Groups | Firewall |
| Route53 | DNS |
| ALB | Load Balancer |
| Amazon ECR | Docker Registry |
| Amazon EKS | Kubernetes |
| Amazon RDS | Database |
| CloudWatch | Metrics & Logs |
| S3 | Backup & Artifacts |
| SNS | Notifications |

---

# 6. Virtual Private Cloud (VPC)

A VPC is an isolated private network inside AWS.

Everything in our project is deployed inside one VPC.

Example

```

VPC

10.0.0.0/16

```

Resources inside the VPC:

- EC2
- EKS
- RDS
- NAT Gateway
- Security Groups

---

# 7. Public & Private Subnets

Our production architecture uses both public and private subnets.

```

VPC

│

├── Public Subnet

│       │

│       ├── ALB

│       ├── NAT Gateway

│       └── Bastion Host

│

└── Private Subnet

        │

        ├── Amazon EKS

        ├── RDS

        └── Internal Services

```

Only public resources are accessible from the Internet.

---

# 8. Internet Gateway

The Internet Gateway allows public resources to communicate with the Internet.

Examples

- Application Load Balancer
- Bastion Host

Private resources never connect directly to the Internet.

---

# 9. NAT Gateway

Private servers sometimes need Internet access.

Example:

- Download Docker packages
- Install Java
- Download Kubernetes packages

Instead of exposing them directly,

Traffic flows through the NAT Gateway.

```

Private EC2

↓

NAT Gateway

↓

Internet

```

---

# 10. EC2 Instances

EC2 provides virtual servers.

Our project uses EC2 for:

- Jenkins
- Ansible Control Node
- Monitoring Server (optional)
- Bastion Host

Example

```

EC2

Ubuntu 22.04

4 vCPU

8 GB RAM

```

---

# 11. IAM (Identity & Access Management)

IAM controls permissions.

Examples

- Jenkins EC2 can push Docker images to ECR.
- Terraform can create infrastructure.
- Ansible can describe EC2 instances.
- Developers cannot delete production resources.

Always follow the Principle of Least Privilege.

---

# 12. Security Groups

Security Groups act as virtual firewalls.

Example

Jenkins

Allow

22 (SSH)

8080 (Jenkins)

Outbound

All

Example

EKS Nodes

Allow

443

10250

Internal Cluster Communication

Never expose unnecessary ports.

---

# 13. Application Load Balancer (ALB)

The ALB distributes incoming traffic across Kubernetes Pods.

```

Users

↓

ALB

↓

Pod-1

Pod-2

Pod-3

```

Benefits:

- High Availability
- Load Distribution
- SSL Termination
- Health Checks

---

# 14. Amazon Elastic Container Registry (ECR)

ECR stores Docker images.

Example

```

banking-app

v1.0.0

v1.0.1

v1.1.0

latest

```

Jenkins pushes images to ECR.

Kubernetes pulls images from ECR.

---

# 15. Amazon Elastic Kubernetes Service (EKS)

EKS manages Kubernetes clusters.

Responsibilities:

- Pod Scheduling
- Rolling Updates
- Auto Healing
- Auto Scaling

Applications run inside Pods.

---

# 16. Amazon RDS

The banking application stores data in Amazon RDS.

Example

MySQL

```

Customers

Accounts

Transactions

Beneficiaries

Loans

```

Database resides in private subnets only.

---

# 17. Amazon Route53

Route53 manages DNS.

Example

```

banking.abcbank.com

↓

Application Load Balancer

```

Users never access EC2 IP addresses directly.

---

# 18. Amazon S3

S3 stores:

- Terraform State
- Backups
- Reports
- Deployment Artifacts
- Logs

Example

```

terraform-state/

database-backups/

reports/

logs/

```

---

# 19. Monitoring

AWS CloudWatch collects

- CPU
- Memory (via Agent)
- Disk
- Network

Prometheus collects Kubernetes metrics.

Grafana visualizes them.

---

# 20. Logging

Application Logs

↓

Fluent Bit

↓

CloudWatch / OpenSearch

↓

Grafana Dashboards

---

# 21. High Availability (HA)

Production must survive failures.

```

ALB

↓

EKS Node 1

↓

EKS Node 2

↓

RDS Multi-AZ

```

If one Availability Zone fails,

Application continues running.

---

# 22. Disaster Recovery (DR)

Daily backups stored in Amazon S3.

RDS automated snapshots.

Terraform recreates infrastructure.

Ansible reconfigures servers.

Kubernetes redeploys applications.

Recovery time is greatly reduced.

---

# 23. Complete AWS Architecture

```

Developer

↓

GitHub

↓

Webhook

↓

Jenkins (EC2)

↓

Maven

↓

SonarQube

↓

Docker

↓

Amazon ECR

↓

Terraform

↓

AWS Infrastructure

↓

Ansible

↓

Amazon EKS

↓

Application

↓

Amazon RDS

↓

Prometheus

↓

Grafana

↓

Slack

```

---

# 24. Real Production Scenario

Developer commits code.

↓

GitHub Webhook triggers Jenkins.

↓

Jenkins builds Docker image.

↓

Image pushed to Amazon ECR.

↓

Terraform validates AWS infrastructure.

↓

Ansible configures EC2 instances.

↓

Kubernetes deploys image to Amazon EKS.

↓

ALB routes traffic to healthy Pods.

↓

Prometheus monitors deployment.

↓

Grafana dashboards update.

↓

Slack notification sent.

Production deployment completed successfully.

---

# 25. AWS Best Practices

- Use private subnets for databases.
- Never expose RDS to the Internet.
- Use IAM Roles instead of access keys.
- Enable Multi-AZ for production databases.
- Store Terraform state in Amazon S3.
- Enable versioning on S3 buckets.
- Encrypt EBS volumes.
- Encrypt RDS storage.
- Use HTTPS everywhere.
- Enable CloudTrail for auditing.
- Enable CloudWatch monitoring.
- Follow the Principle of Least Privilege.

---

# 26. Common Mistakes

❌ Using the root AWS account.

❌ Storing AWS keys in GitHub.

❌ Opening Security Groups to 0.0.0.0/0 unnecessarily.

❌ Deploying databases in public subnets.

❌ No backup strategy.

❌ No monitoring.

❌ No infrastructure version control.

❌ Manual infrastructure changes outside Terraform.

---

# 27. Interview Questions

1. Explain your AWS Architecture.
2. Why do you use VPC?
3. Difference between Public and Private Subnets.
4. Why use a NAT Gateway?
5. Why is RDS placed in a Private Subnet?
6. Explain Security Groups.
7. Why use EKS instead of self-managed Kubernetes?
8. Explain Amazon ECR.
9. How do you secure AWS credentials?
10. Explain High Availability in your architecture.
11. Explain Disaster Recovery.
12. Why use Route53?
13. Explain the end-to-end deployment flow on AWS.

---

# 28. Key Takeaways

- AWS provides the cloud foundation for our DevOps platform.
- Infrastructure is fully automated using Terraform.
- Server configuration is managed using Ansible.
- Applications are deployed on Amazon EKS.
- Docker images are stored in Amazon ECR.
- Monitoring, logging, security, and scalability are built into the architecture.
- Every AWS service has a clearly defined role in the end-to-end deployment pipeline.

---

# 29. What's Next?

The next documents will build directly on this AWS architecture:

08-Git-Fundamentals.md

09-GitHub-Enterprise.md

10-Git-Branching-Strategy.md

11-GitHub-Webhooks.md

12-Jenkins-Architecture.md

13-Maven-Build-System.md

14-SonarQube.md

15-Docker.md

16-Terraform.md

17-Ansible.md

18-Kubernetes.md