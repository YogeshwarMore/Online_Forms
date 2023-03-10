USE [master]
GO
/****** Object:  Database [Forms]    Script Date: 23-02-2023 18:26:15 ******/
CREATE DATABASE [Forms]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Forms', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\Forms.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Forms_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\Forms_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Forms] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Forms].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Forms] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Forms] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Forms] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Forms] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Forms] SET ARITHABORT OFF 
GO
ALTER DATABASE [Forms] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Forms] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Forms] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Forms] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Forms] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Forms] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Forms] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Forms] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Forms] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Forms] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Forms] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Forms] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Forms] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Forms] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Forms] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Forms] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Forms] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Forms] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Forms] SET  MULTI_USER 
GO
ALTER DATABASE [Forms] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Forms] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Forms] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Forms] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Forms] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Forms] SET QUERY_STORE = OFF
GO
USE [Forms]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [Forms]
GO
/****** Object:  Table [dbo].[filledForm]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[filledForm](
	[filledFormId] [int] IDENTITY(1,1) NOT NULL,
	[formId] [int] NULL,
	[fillDate] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[filledFormId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[filledFormField]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[filledFormField](
	[filledFormFieldId] [int] IDENTITY(1,1) NOT NULL,
	[filledFormId] [int] NOT NULL,
	[formFieldId] [int] NOT NULL,
	[isChecked] [bit] NULL,
	[textValue] [nvarchar](255) NULL,
	[numericValue] [decimal](16, 8) NULL,
	[dateTimeValue] [datetime] NULL,
	[optionId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[filledFormFieldId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[options]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[options](
	[optionId] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
 CONSTRAINT [PK__options__3D5DC2219B3E6153] PRIMARY KEY CLUSTERED 
(
	[optionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[dm]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[dm] as
select ff.formId,o.name,fff.textValue,fff.isChecked from options o 
full join filledFormField fff on fff.optionId=o.optionId 
inner join filledForm ff on ff.filledFormId=fff.filledFormId 
GO
/****** Object:  Table [dbo].[Form]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Form](
	[formId] [int] IDENTITY(1,1) NOT NULL,
	[formName] [varchar](255) NOT NULL,
	[Description] [varchar](255) NOT NULL,
	[creationDate] [date] NOT NULL,
	[changeDate] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[formId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[formGroup]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[formGroup](
	[formGroupId] [int] IDENTITY(1,1) NOT NULL,
	[formId] [int] NOT NULL,
	[Name] [varchar](255) NOT NULL,
	[Indexs] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[formGroupId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[formField]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[formField](
	[formFieldId] [int] IDENTITY(1,1) NOT NULL,
	[formGroupId] [int] NOT NULL,
	[fieldName] [varchar](255) NOT NULL,
	[Id] [int] NOT NULL,
	[Indexs] [int] NOT NULL,
	[isOptional] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[formFieldId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[fieldData]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[fieldData](@id int)
returns table 
as 
return select f.formId, f.formname,ff.fieldname,ff.isOptional from form f 
inner join formGroup fg on fg.formid=f.formid
inner join formField ff on ff.formGroupId=fg.formGroupId where f.formId=@id; 
GO
/****** Object:  View [dbo].[AllForms]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[AllForms] 
as 
Select f.formname,f.Description,f.creationDate from Form f ; 
GO
/****** Object:  Table [dbo].[optionFormFields]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[optionFormFields](
	[optionId] [int] NOT NULL,
	[formFieldId] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ToolBox]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ToolBox](
	[toolId] [int] NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[toolId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[filledForm] ADD  DEFAULT (getdate()) FOR [fillDate]
GO
ALTER TABLE [dbo].[Form] ADD  DEFAULT (getdate()) FOR [creationDate]
GO
ALTER TABLE [dbo].[Form] ADD  DEFAULT (getdate()) FOR [changeDate]
GO
ALTER TABLE [dbo].[filledForm]  WITH CHECK ADD FOREIGN KEY([formId])
REFERENCES [dbo].[Form] ([formId])
GO
ALTER TABLE [dbo].[filledFormField]  WITH CHECK ADD FOREIGN KEY([filledFormId])
REFERENCES [dbo].[filledForm] ([filledFormId])
GO
ALTER TABLE [dbo].[filledFormField]  WITH CHECK ADD FOREIGN KEY([formFieldId])
REFERENCES [dbo].[formField] ([formFieldId])
GO
ALTER TABLE [dbo].[filledFormField]  WITH CHECK ADD  CONSTRAINT [FK__filledFor__optio__3A81B327] FOREIGN KEY([optionId])
REFERENCES [dbo].[options] ([optionId])
GO
ALTER TABLE [dbo].[filledFormField] CHECK CONSTRAINT [FK__filledFor__optio__3A81B327]
GO
ALTER TABLE [dbo].[formField]  WITH CHECK ADD FOREIGN KEY([formGroupId])
REFERENCES [dbo].[formGroup] ([formGroupId])
GO
ALTER TABLE [dbo].[formField]  WITH CHECK ADD FOREIGN KEY([Id])
REFERENCES [dbo].[ToolBox] ([toolId])
GO
ALTER TABLE [dbo].[formGroup]  WITH CHECK ADD FOREIGN KEY([formId])
REFERENCES [dbo].[Form] ([formId])
GO
ALTER TABLE [dbo].[optionFormFields]  WITH CHECK ADD FOREIGN KEY([formFieldId])
REFERENCES [dbo].[formField] ([formFieldId])
GO
ALTER TABLE [dbo].[optionFormFields]  WITH CHECK ADD  CONSTRAINT [FK__optionFor__optio__30F848ED] FOREIGN KEY([optionId])
REFERENCES [dbo].[options] ([optionId])
GO
ALTER TABLE [dbo].[optionFormFields] CHECK CONSTRAINT [FK__optionFor__optio__30F848ED]
GO
/****** Object:  StoredProcedure [dbo].[getdata]    Script Date: 23-02-2023 18:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create Procedure [dbo].[getdata]
as
begin
select ff.formId,ff1.fieldname,CONCAT( o.name,fff.textValue) as "Field Name",fff.isChecked from options o 
full join filledFormField fff on fff.optionId=o.optionId 
inner join filledForm ff on ff.filledFormId=fff.filledFormId 
inner join form f on ff.formId=f.formId
inner join formField ff1 on ff1.formFieldId=fff.formFieldId;
end 
GO
USE [master]
GO
ALTER DATABASE [Forms] SET  READ_WRITE 
GO
